import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BookShop } from 'src/app/model/bookShop.model';

@Injectable({
  providedIn: 'root'
})
export class BookshopService {
  bookShopURL:string='http://localhost:8080/api/bookshops'
  constructor(private http:HttpClient) {}

  getBookShops():Observable<BookShop [] >{
    return this.http.get<BookShop []>(this.bookShopURL);
  }

  getBookShop(bookShopId:number):Observable<BookShop>{
    return this.http.get<BookShop>(
      this.bookShopURL.concat('/'.concat(bookShopId.toString())))
  }
  updateBookShop(bookShop:BookShop):Observable<string>{
    return this.http.put<string>(
      this.bookShopURL.concat('/'.concat(bookShop.bookShopId.toString())),bookShop)    
  }

  deleteBookShop(bookShopId:number):Observable<string>{
    return this.http.delete<string>(this.bookShopURL.concat('/'.concat(bookShopId.toString())))
  }
  addBookShop(bookShop:BookShop):Observable<string>{
    return this.http.post<string>(
      this.bookShopURL,bookShop)
  }
}
