import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from '../../model/book.model';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  bookURL:string='http://localhost:8080/api/books'
  bookImageURl:string=this.bookURL+"/image"
  constructor(private http:HttpClient) { }

  getBooks():Observable<Book [] >{
    //   return  [
    //     {bookId:1,title:'abc',price:150,genre:'horror',publisher:'penguin'}
    //     ];
    // return of([{bookId:1,title:'abc',price:150,genre:'horror',publisher:'penguin'}])
    return this.http.get<Book []>(this.bookURL)
  }

  deleteBook(bookId:number):Observable<string>{
    return this.http.delete<string>(this.bookURL.concat('/'.concat(bookId.toString())))
  }

  updateBook(book:Book):Observable<string>{
    return this.http.put<string>(this.bookURL.concat('/'.concat(book.bookId.toString())),book)
  }

  addBook(book:Book):Observable<string>{
    return this.http.post<string>(this.bookURL,book);
  }

  getBookImage(bookId:number):Observable<any>{
    return this.http.get(this.bookImageURl.concat('/'.concat(bookId.toString())),{ responseType: 'blob' })
  }

}
