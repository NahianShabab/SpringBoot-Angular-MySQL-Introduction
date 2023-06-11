package com.vinternship.task3.Service;

import com.vinternship.task3.Model.Book;
import com.vinternship.task3.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.*;
import java.util.Optional;

@Service
public class BookService {
    private Path bookImagePath= Paths.get("book-images");
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

    public void addFile()throws IOException{
        FileOutputStream fileOutputStream=new FileOutputStream("./book-images/1.txt");
    }

    public Resource loadImage(Long bookId){
        try {
            Path filePath=bookImagePath.resolve(bookId+".png");
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                Path defaultFilePath=bookImagePath.resolve("default.png");
                Resource defaultResource = new UrlResource(defaultFilePath.toUri());
                return  defaultResource;
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public void uploadImage(long bookId, MultipartFile file){
        try {
            Files.copy(file.getInputStream(),bookImagePath.resolve(bookId+".png"), StandardCopyOption.REPLACE_EXISTING);
        }catch (Exception e){
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

}
