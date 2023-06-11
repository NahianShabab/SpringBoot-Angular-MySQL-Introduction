import { Component, Input, OnInit } from '@angular/core';
import { Book } from 'src/app/model/book.model';
import { Output, EventEmitter } from '@angular/core';
import { BookService } from 'src/app/services/book/book.service';


@Component({
  selector: 'app-show-book',
  templateUrl: './show-book.component.html',
  styleUrls: ['./show-book.component.css']
})
export class ShowBookComponent implements OnInit {
  @Input() book?: Book
  @Output() bookSelectEvent = new EventEmitter<Book>();
  bookImage: any

  constructor(private bookService: BookService) { }

  ngOnInit(): void {
    if (this.book) {
      this.bookService.getBookImage(this.book.bookId)
        .subscribe(
          (data) => {
            const reader = new FileReader();
            reader.onloadend = () => {
              this.bookImage = reader.result;
            };
            reader.readAsDataURL(data);
          }
        )
    }

  }

  onClick(): void {
    this.bookSelectEvent.emit(this.book);
  }
}
