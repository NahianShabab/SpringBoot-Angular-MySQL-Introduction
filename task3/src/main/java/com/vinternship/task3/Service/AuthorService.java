//package com.vinternship.task4.Service;
//
//import com.vinternship.task4.Model.Author;
//import com.vinternship.task4.Repository.AuthorRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AuthorService {
//    @Autowired
//    private AuthorRepository authorRepository;
//    public Iterable<Author> getAllAuthors(){
//        return authorRepository.findAll();
//    }
//    public void addAuthor(Author author){
//        authorRepository.save(author);
//    }
//
//    public void deleteAuthor(long authorId){
//        authorRepository.deleteById(authorId);
//    }
//
//}
