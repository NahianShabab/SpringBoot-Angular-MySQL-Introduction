package com.vinternship.task3.Service;

import com.vinternship.task3.Model.BookShop;
import com.vinternship.task3.Repository.BookRepository;
import com.vinternship.task3.Repository.BookShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vinternship.task3.Model.Book;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;

import static java.util.Arrays.asList;

@Service
public class BookShopService {
    @Autowired
    private BookShopRepository bookShopRepository;
    @Autowired
    private BookService bookService;
    public Iterable<BookShop> getAllBookShops(){
        return bookShopRepository.findAll();
    }
    public void addBookShop(BookShop bookShop){
        bookShopRepository.save(bookShop);
    }
    public Optional<BookShop> getBookShop(long bookShopId){
        return bookShopRepository.findById(bookShopId);
    }
    public void updateBookShop(BookShop requestedBookShop,long bookShopId){
        Optional<BookShop> oldBookShop=bookShopRepository.findById(bookShopId);
        if(oldBookShop.isPresent()){
            BookShop updatedBookShop=oldBookShop.get();
            updatedBookShop.setBooks(requestedBookShop.getBooks());
            updatedBookShop.setTitle(requestedBookShop.getTitle());
            updatedBookShop.setEmail(requestedBookShop.getEmail());
            updatedBookShop.setLocation(requestedBookShop.getLocation());
            updatedBookShop.setContactNo(requestedBookShop.getContactNo());
            bookShopRepository.save(updatedBookShop);
        }
    }
    public void deleteBookShop(long bookShopId){
        bookShopRepository.deleteById(bookShopId);
    }
    public void deleteAllBookShops(){
        bookShopRepository.deleteAll();
    }

}

