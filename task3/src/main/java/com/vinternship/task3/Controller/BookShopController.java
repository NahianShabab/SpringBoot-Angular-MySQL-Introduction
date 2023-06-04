package com.vinternship.task3.Controller;

import com.vinternship.task3.Model.BookShop;
import com.vinternship.task3.Service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/bookshops")
public class BookShopController {
    @Autowired
    private BookShopService bookShopService;

    @PostMapping("")
    public @ResponseBody String addBookShop(@RequestBody BookShop bookShop){
        bookShopService.addBookShop(bookShop);
        return "BookShop Added";
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
    public @ResponseBody String updateBookShop(@PathVariable long id,@RequestBody BookShop bookShop){
        bookShopService.updateBookShop(bookShop,id);
        return "BookShop Updated";
    }

    @DeleteMapping("/{id}")
    public @ResponseBody String deleteBookShop(@PathVariable long id){
        bookShopService.deleteBookShop(id);
        return "BookShop deleted";
    }

    @DeleteMapping("")
    public @ResponseBody String deleteAllBookShops(){
        bookShopService.deleteAllBookShops();
        return "All BookShops deleted";
    }






}
