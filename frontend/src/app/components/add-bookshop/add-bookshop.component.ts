import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { Book } from 'src/app/model/book.model';
import { BookShop } from 'src/app/model/bookShop.model';
import { BookshopService } from 'src/app/services/bookshop/bookshop.service';

@Component({
  selector: 'app-add-bookshop',
  templateUrl: './add-bookshop.component.html',
  styleUrls: ['./add-bookshop.component.css']
})
export class AddBookshopComponent implements OnInit {
  bookShopForm: FormGroup;
  constructor(public dialogRef: MatDialogRef<AddBookshopComponent>,
    private formBuilder: FormBuilder,
    public bookService: BookshopService) { 
      this.bookShopForm=formBuilder.group(
        {
          title: ['', Validators.required],
          location: ['', Validators.required],
          contactNo: ['', Validators.required],
          email: ['', Validators.required],
        }
      )
    }

  ngOnInit(): void {
  }

  add():void{
    if (this.bookShopForm.valid) {
      let title: string = this.bookShopForm.get('title')?.value
      let location: string = this.bookShopForm.get('location')?.value
      let contactNo: string = this.bookShopForm.get('contactNo')?.value
      let email: string = this.bookShopForm.get('email')?.value
      let bookShopId:number=-1
      let books:Book[]=[]
      let bookShop:BookShop={title,location,contactNo,email,bookShopId,books}
      this.bookService.addBookShop(bookShop)
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
