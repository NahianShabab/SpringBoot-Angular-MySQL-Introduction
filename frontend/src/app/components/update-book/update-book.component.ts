import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Book } from 'src/app/model/book.model';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { BookService } from 'src/app/services/book/book.service';

@Component({
  selector: 'app-update-book',
  templateUrl: './update-book.component.html',
  styleUrls: ['./update-book.component.css']
})
export class UpdateBookComponent implements OnInit {
  bookForm: FormGroup;
  constructor(public dialogRef: MatDialogRef<UpdateBookComponent>,
    @Inject(MAT_DIALOG_DATA) public book: Book, private formBuilder: FormBuilder,
    public bookService: BookService) {
    this.bookForm = formBuilder.group({
      title: [book.title, Validators.required],
      publisher: [book.publisher, Validators.required],
      genre: [book.genre, Validators.required],
      // angular seems to match "123." number for the
      // pattern "([0-9]*[.][0-9]+)"
      // this may be bug in angular
      // so for now numbers like ".34" is declared invalid
      price: [book.price, [Validators.required, Validators.pattern("([0-9]+([.][0-9]+)?)")]]
    });
  }

  ngOnInit(): void {

  }

  update(): void {
    if (this.bookForm.valid) {

      let title: string = this.bookForm.get('title')?.value
      let price: number = this.bookForm.get('price')?.value
      let genre: string = this.bookForm.get('genre')?.value
      let publisher: string = this.bookForm.get('publisher')?.value
      let bookId: number = this.book.bookId

      this.bookService.updateBook({ title, bookId, genre, publisher, price })
        .subscribe(
          value => {
            console.log(value);
            this.dialogRef.close({ updated: true });
          },
          error => {
            console.log(error);

          }
        )
    }
  }

  delete(): void {
    if (this.bookForm.valid) {
      this.bookService.deleteBook(this.book.bookId)
        .subscribe(
          value => {
            console.log(value);
            this.dialogRef.close({ updated: true });

          },
          error => {
            console.log(error);
            this.dialogRef.close({ updated: false });
          }
        )
    }

  }

}