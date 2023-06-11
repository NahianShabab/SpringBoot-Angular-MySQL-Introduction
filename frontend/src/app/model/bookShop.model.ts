import { Book } from "./book.model"
export interface BookShop{
    bookShopId:number,
    title:string,
    location:string,
    contactNo:string,
    email:string,
    books:Book[]
};


// let bookShop:BookShop={
//     bookShopId:1,
//     title:'1',
//     location:'2',
//     contactNo:'3',
//     email:'33',
//     books:new Set<Book>([{bookId:1,title:'1',
// price:1,genre:'ssd',publisher:'d'}])
// }
