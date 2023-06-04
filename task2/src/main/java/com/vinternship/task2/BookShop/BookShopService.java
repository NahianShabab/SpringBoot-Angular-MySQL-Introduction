package com.vinternship.task2.BookShop;

import com.vinternship.task2.Book.Book;
import com.vinternship.task2.Book.BookRepository;
import com.vinternship.task2.Book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookShopService {
    @Autowired
    private BookShopRepository bookShopRepository;
    @Autowired
    BookRepository bookRepository;

    public Iterable<BookShop> getAllBookShops(){
        return bookShopRepository.findAll();
    }

    public void addBook(Long bookShopNumber,Long bookId){
        BookShop bookShop=bookShopRepository.findById(bookShopNumber).get();
        Book book=bookRepository.findById(bookId).get();
        bookShop.getBooks().add(book);
        bookShopRepository.save(bookShop);
    }
    public void addBookShop(BookShop bookShop){
        bookShopRepository.save(bookShop);
    }

    public void deleteBook(long bookShopNumber,long bookId){
        BookShop bookShop=bookShopRepository.findById(bookShopNumber).get();
        Book book=bookRepository.findById(bookId).get();
        bookShop.getBooks().remove(book);
        bookShopRepository.save(bookShop);
    }
}
