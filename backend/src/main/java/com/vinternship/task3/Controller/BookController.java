package com.vinternship.task3.Controller;

import com.vinternship.task3.Model.Book;
import com.vinternship.task3.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
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
    public @ResponseBody void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody void deleteBook(@PathVariable long id){
        bookService.deleteBook(id);
//        return ResponseEntity.ok("Book Deleted");
    }
    @PutMapping("/{id}")
    public void updateBook(@PathVariable long id,@RequestBody Book book){
        bookService.updateBook(book,id);
    }
    @GetMapping("/{id}")
    public @ResponseBody Optional<Book> getBookById(@PathVariable long id){
        return bookService.getBookById(id);
    }
    @DeleteMapping("")
    public void deleteAllBooks(){
        bookService.deleteAllBooks();
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<Resource> getImage(@PathVariable long id)throws IOException{
        Resource file= bookService.loadImage(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);

        return ResponseEntity.ok()
                .headers(headers).body(file);
    }

    @PutMapping("/image/{id}")
    public void uploadImage(@RequestParam("file") MultipartFile file,@PathVariable long id) {
        try {
            bookService.uploadImage(id,file);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
