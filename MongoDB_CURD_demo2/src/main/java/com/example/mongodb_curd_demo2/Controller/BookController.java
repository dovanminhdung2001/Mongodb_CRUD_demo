package com.example.mongodb_curd_demo2.Controller;

import com.example.mongodb_curd_demo2.Repository.BookRepository;
import com.example.mongodb_curd_demo2.Repository.CategoryRepository;
import com.example.mongodb_curd_demo2.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @PutMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        try {
            if (categoryRepository.findById(book.getCategoryId()).isPresent()) {
                Book book2 = bookRepository.save(new Book(book.getCategoryId(), book.getName(), book.getAuthor(), book.isPublished()));
                return new ResponseEntity<>(book2, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> findAllBook (@RequestParam(required = false) String name) {
        try {
            List<Book> books = new ArrayList<>(name == null
                    ? bookRepository.findAll()
                    : bookRepository.findByNameContaining(name));
            return books.isEmpty()
                    ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                    : new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> findBookById (@PathVariable("id") String id ) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        return bookOptional.isPresent()
                ? new ResponseEntity<>(bookOptional.get(), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/books/published")
    public ResponseEntity<List<Book>> findPublishedBook() {
        try {
            List<Book> books = bookRepository.findByPublished(true);
            return books.isEmpty()
                    ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                    : new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook (@PathVariable("id") String id, @RequestBody Book book) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()){
            if (categoryRepository.findById(book.getCategoryId()).isPresent()) {
                Book book2 = bookOptional.get();
                book2.setCategoryId(book.getCategoryId());
                book2.setName(book.getName());
                book2.setAuthor(book.getAuthor());
                book2.setPublished(book.isPublished());
                return new ResponseEntity<>(bookRepository.save(book2), HttpStatus.OK);
            }
            return  new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}










