import { Component, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA,MatDialog,MatDialogRef} from '@angular/material/dialog';
import { Book } from 'src/app/model/book.model';
// import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';

import { BookService } from 'src/app/services/book/book.service';
import { AddBookComponent } from '../add-book/add-book.component';
import { UpdateBookComponent } from '../update-book/update-book.component';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})

export class BooksComponent implements OnInit {
  books: Book[]=[]
  filteredBooks:Book[]=[]
  constructor(private bookService:BookService,private editDialog:MatDialog) {

  }

  getBooks():void{
    this.bookService.getBooks()
    .subscribe(books=>{
      this.books=books;
      this.applyFilter();
    });

     
  }

  ngOnInit(): void {
    this.getBooks()
  }

  applyFilter():void{
    this.filteredBooks=this.books
    // this.filteredBooks=this.books.filter(
    //   book=>book.title.startsWith("")
    // )
  }

  bookSelected(selectedBook:Book):void{
    // console.log(selectedBook);
    this.openEditDialogue(selectedBook);
  }

  deleteBook(book:Book):void{
    this.bookService.deleteBook(book.bookId)
    .subscribe();
    this.getBooks();
  }

  openEditDialogue(selectedBook:Book):void{
    const dialogRef=this.editDialog.open(UpdateBookComponent,{data:selectedBook,width:'300px'});
    dialogRef.afterClosed()
    .subscribe(value=>{
      if(value.updated){
        this.getBooks()
      }
    })
  }

  openAddDialogue():void{
    const dialogRef=this.editDialog.open(AddBookComponent,{width:'300px'});
    dialogRef.afterClosed()
    .subscribe(value=>{
      if(value.updated){
        this.getBooks()
      }
    })
  }

}
