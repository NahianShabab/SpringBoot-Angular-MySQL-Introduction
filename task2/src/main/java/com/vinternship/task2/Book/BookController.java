package com.vinternship.task2.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
    @PostMapping(path = "/add")
    public @ResponseBody String addBook(Book book){
        bookService.addBook(book);
        return "Book Added";
    }
}
