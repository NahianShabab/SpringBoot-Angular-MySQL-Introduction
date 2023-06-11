import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookShopInfoComponent } from './components/book-shop-info/book-shop-info.component';
import { BookShopComponent } from './components/book-shop/book-shop.component';
import { BooksComponent } from './components/books/books.component';
import { ExtraOptions } from '@angular/router';

const routes: Routes = [
  {path:'books' ,component:BooksComponent},
  {path:'bookshops',component:BookShopComponent},
  {path:'bookshops/:id',component:BookShopInfoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  
})
export class AppRoutingModule { }
