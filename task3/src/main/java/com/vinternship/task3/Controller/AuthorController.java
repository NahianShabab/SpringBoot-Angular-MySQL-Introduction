//package com.vinternship.task4.Controller;
//
//import com.vinternship.task4.Model.Author;
//import com.vinternship.task4.Service.AuthorService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/authors")
//public class AuthorController {
//    @Autowired
//    private AuthorService authorService;
//
//    @GetMapping("")
//    public @ResponseBody Iterable<Author> getAllAuthors(){
//        return authorService.getAllAuthors();
//    }
//    @PostMapping("")
//    public @ResponseBody String addAuthor(@RequestBody Author author){
//        authorService.addAuthor(author);
//        return "Author added";
//    }
//    @DeleteMapping("/{id}")
//    public @ResponseBody String deleteBook(@PathVariable long id){
//        authorService.deleteAuthor(id);
//        return "Author deleted";
//    }
//}
