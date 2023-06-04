package com.vinternship.task2.BookShop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookshop")
public class BookShopController {
    @Autowired
    private BookShopService bookShopService;

    @GetMapping("/all")
    public @ResponseBody Iterable<BookShop> getAllBookShops(){
        return bookShopService.getAllBookShops();
    }
    @PatchMapping("/addBook")
    public @ResponseBody String addBook(@RequestParam Long bookShopNumber,@RequestParam Long bookId){
        bookShopService.addBook(bookShopNumber,bookId);
        return "Book Added to BookShop";
    }
    @PutMapping("/add")
    public @ResponseBody String addBookShop(@RequestParam BookShop bookShop){
        bookShopService.addBookShop(bookShop);
        return "Book Shop Added";
    }
    @DeleteMapping("/deleteBook")
    public @ResponseBody String deleteBook(@RequestParam long bookShopNumber,@RequestParam long bookId){
        bookShopService.deleteBook(bookShopNumber,bookId);
        return "Book deleted from bookshop";
    }
}
