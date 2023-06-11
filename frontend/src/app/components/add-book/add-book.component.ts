import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { Book } from 'src/app/model/book.model';
import { BookService } from 'src/app/services/book/book.service';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {
  bookForm: FormGroup;
  constructor(public dialogRef: MatDialogRef<AddBookComponent>,
    private formBuilder: FormBuilder,
    public bookService: BookService) {
    this.bookForm = formBuilder.group({
      title: ['', Validators.required],
      publisher: ['', Validators.required],
      genre: ['', Validators.required],
      // angular seems to match "123." number for the
      // pattern "([0-9]*[.][0-9]+)"
      // this may be bug in angular
      // so for now numbers like ".34" is declared invalid
      price: ['', [Validators.required, Validators.pattern("([0-9]+([.][0-9]+)?)")]]
    })
  }

  ngOnInit(): void {
  }

  add():void{
    if (this.bookForm.valid) {
      let title: string = this.bookForm.get('title')?.value
      let price: number = this.bookForm.get('price')?.value
      let genre: string = this.bookForm.get('genre')?.value
      let publisher: string = this.bookForm.get('publisher')?.value
      // bookId not needed in api
      let bookId:number=-1
      let book:Book={title,price,genre,publisher,bookId}
      this.bookService.addBook(book)
        .subscribe(
          value => {
            console.log("Added from component");
            this.dialogRef.close({ updated: true });

          },
          error => {
            console.log(error);
            console.log("not added");
            this.dialogRef.close({ updated: false });
          }
        )
    }
  }

}
