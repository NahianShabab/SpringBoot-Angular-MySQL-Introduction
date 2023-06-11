import { Component, Directive, Input, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSelect } from '@angular/material/select';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from 'src/app/model/book.model';
import { BookShop } from 'src/app/model/bookShop.model';
import { BookService } from 'src/app/services/book/book.service';
import { BookshopService } from 'src/app/services/bookshop/bookshop.service';


@Component({
  selector: 'app-book-shop-info',
  templateUrl: './book-shop-info.component.html',
  styleUrls: ['./book-shop-info.component.css']
})

export class BookShopInfoComponent implements OnInit {
  bookShopId:number=NaN;
  bookShop?:BookShop
  bookShopForm:FormGroup
  // books that can be added to the bookshop
  addAbleBooks:Book[]=[]
  addedBooks:Book[]=[]
  constructor(private route: ActivatedRoute,private bookShopService:BookshopService,
    private router:Router,private formBuilder:FormBuilder,private bookService:BookService) {
    this.route.params.subscribe(params=>{
      let id:any=this.route.snapshot.paramMap.get('id')
      this.bookShopId=parseInt(id)
      if(isNaN(this.bookShopId)){
        console.log("NAN discovered ",this.bookShopId);
        // redirect to 404 not found
        this.router.navigate(['/bookshops'])
        
      }else{
        console.log("Number Discovered: ",this.bookShopId);
        this.getBookShop() 
      }
    })

    this.bookShopForm=formBuilder.group(
      {
        title:['',Validators.required],
        location:['',Validators.required],
        contactNo:['',Validators.required],
        email:['',Validators.required]
        
      }
    )
  }

  ngOnInit(): void {
  }

  getBookShop():void{
    if(isNaN(this.bookShopId)==false){
      this.bookShopService.getBookShop(this.bookShopId)
      .subscribe(
        bookShop=>{
          this.bookShop=bookShop
          this.bookShopForm.get('title')?.setValue(bookShop.title)
          this.bookShopForm.get('location')?.setValue(bookShop.location)
          this.bookShopForm.get('contactNo')?.setValue(bookShop.contactNo)
          this.bookShopForm.get('email')?.setValue(bookShop.email)
        }
      )
      this.loadAddBooks()
    }
  }

  updateBookShop():void{
    if(this.bookShop && this.bookShopForm.invalid==false ){
      let title:string=this.bookShopForm.get('title')?.value
      let location:string=this.bookShopForm.get('location')?.value
      let contactNo:string= this.bookShopForm.get('contactNo')?.value
      let email:string=this.bookShopForm.get('email')?.value
      let bookShopId:number=this.bookShop?.bookShopId
      this.addedBooks.forEach(book=>this.bookShop?.books.push(book))
      this.addedBooks=[]
      let books:Book[]=this.bookShop?.books
      let updatedBookShop:BookShop={bookShopId,title,location,contactNo,email,books}
      this.bookShopService.updateBookShop(updatedBookShop)
      .subscribe(
        value=>{
          this.getBookShop()
        },
        error=>{
        }
      )
    }

  }
  deleteBookShop():void{
    if(this.bookShop){
      this.bookShopService.deleteBookShop(this.bookShop?.bookShopId)
      .subscribe(
        value=>{
          this.router.navigate(['/bookshops'])
        },
        error=>{

        }
      )
    }
  }
  
  loadAddBooks():void{
    this.addAbleBooks=[]
    this.bookService.getBooks()
    .subscribe(
      books=>{
        let allBooks:Book[]=books;
        for (const book of allBooks) {
          const isBookAdded = this.addedBooks.some((addedBook) => addedBook.bookId === book.bookId);
          const isBookCurrent = this.bookShop?.books.some((currentBook) => currentBook.bookId === book.bookId);
        
          if (!isBookAdded && !isBookCurrent) {
            this.addAbleBooks.push(book);
          }
        }
        console.log(this.addAbleBooks);

        
        
      }
    )
  }

  removeFromAddedBooks(book:Book){
    this.addedBooks.splice(this.addedBooks.indexOf(book),1)
    this.addAbleBooks.push(book)
  }

  addToAddedBooks(book:Book){
    console.log(book);
    
    this.addedBooks.push(book);
    this.addAbleBooks.splice(this.addAbleBooks.indexOf(book),1)
  }

  bookSelected(book:Book):void{
    this.bookShop?.books.splice(this.bookShop.books.indexOf(book),1)
    this.updateBookShop()
    
  }

}
