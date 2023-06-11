import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { BookShop } from 'src/app/model/bookShop.model';
import { BookshopService } from 'src/app/services/bookshop/bookshop.service';
import { AddBookshopComponent } from '../add-bookshop/add-bookshop.component';

@Component({
  selector: 'app-book-shop',
  templateUrl: './book-shop.component.html',
  styleUrls: ['./book-shop.component.css']
})
export class BookShopComponent implements OnInit {
  bookShops:BookShop[]=[]/*[{bookShopId:1,title:'1',location:'1',contactNo:'11',email:'11',books:[]}]*/
  displayedColumns: string[] = ['title', 'location', 'contactNo', 'email','view','delete'];
  constructor(private bookShopService:BookshopService
    ,private editDialog:MatDialog) { }

  ngOnInit(): void {
    this.getBookShops()
  }

  getBookShops():void{
    this.bookShopService.getBookShops()
    .subscribe(
      bookShops=>{
        this.bookShops=bookShops;
        console.log(this.bookShops);
        
      }
    )
  }

  openAddDialogue():void{
    const dialogRef=this.editDialog.open(AddBookshopComponent,{width:'300px'});
    dialogRef.afterClosed()
    .subscribe(value=>{
      if(value.updated){
        this.getBookShops()
      }
    })
  }

  deleteBook(bookShopId:number):void{
    this.bookShopService.deleteBookShop(bookShopId)
      .subscribe(
        value=>{
          this.getBookShops()
        },
        error=>{
          this.getBookShops()
        }
      )
  }


}
