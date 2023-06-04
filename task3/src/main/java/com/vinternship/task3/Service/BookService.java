package com.vinternship.task3.Service;

import com.vinternship.task3.Model.Book;
import com.vinternship.task3.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Iterable<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(long bookId){
        return bookRepository.findById(bookId);
    }

//    public Optional<Book> getBookByTitle(String title){
//    }
    public void addBook(Book book){
        bookRepository.save(book);
    }

    public void deleteBook(long bookId){
        bookRepository.deleteById(bookId);
    }

    public void updateBook(Book requestedBook,long bookId){
        Optional<Book> oldBook=bookRepository.findById(bookId);
        if(oldBook.isPresent()){
            Book updatedBook=oldBook.get();
            updatedBook.setTitle(requestedBook.getTitle());
            updatedBook.setGenre(requestedBook.getGenre());
            updatedBook.setPrice(requestedBook.getPrice());
            updatedBook.setPublisher(requestedBook.getPublisher());
            bookRepository.save(updatedBook);
        }
    }

    public void deleteAllBooks(){bookRepository.deleteAll();}



}
