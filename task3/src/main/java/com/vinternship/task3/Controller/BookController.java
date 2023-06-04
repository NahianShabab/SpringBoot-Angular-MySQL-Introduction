package com.vinternship.task3.Controller;

import com.vinternship.task3.Model.Book;
import com.vinternship.task3.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("")
    public @ResponseBody Iterable<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping("")
    public @ResponseBody String addBook(@RequestBody Book book){
        bookService.addBook(book);
        return "Book Added";
    }

    @DeleteMapping("/{id}")
    public @ResponseBody String deleteBook(@PathVariable long id){
        bookService.deleteBook(id);
        return "Book deleted";
    }
    @PutMapping("/{id}")
    public @ResponseBody String updateBook(@PathVariable long id,@RequestBody Book book){
        bookService.updateBook(book,id);
        return "Book Updated";
    }
    @GetMapping("/{id}")
    public @ResponseBody Optional<Book> getBookById(@PathVariable long id){
        return bookService.getBookById(id);
    }
    @DeleteMapping("")
    public @ResponseBody String deleteAllBooks(){
        bookService.deleteAllBooks();
        return "All Books Deleted";
    }
}
