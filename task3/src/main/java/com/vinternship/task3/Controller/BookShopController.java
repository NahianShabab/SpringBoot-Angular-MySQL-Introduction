package com.vinternship.task3.Controller;

import com.vinternship.task3.Model.Book;
import com.vinternship.task3.Model.BookShop;
import com.vinternship.task3.Service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/bookshops")
public class BookShopController {
    @Autowired
    private BookShopService bookShopService;

    @PostMapping("")
    public void addBookShop(@RequestBody BookShop bookShop){
        bookShopService.addBookShop(bookShop);
    }

    @GetMapping("")
    public @ResponseBody Iterable<BookShop> getAllBookShops(){
        return bookShopService.getAllBookShops();
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<BookShop> getBookShopById(@PathVariable long id){
        return bookShopService.getBookShop(id);
    }
    @PutMapping("/{id}")
    public void updateBookShop(@PathVariable long id,@RequestBody BookShop bookShop){
        bookShopService.updateBookShop(bookShop,id);
    }

    @DeleteMapping("/{id}")
    public void deleteBookShop(@PathVariable long id){
        bookShopService.deleteBookShop(id);
    }

    @DeleteMapping("")
    public void deleteAllBookShops(){
        bookShopService.deleteAllBookShops();
    }






}
