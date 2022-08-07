package com.example.mongodb_crud_check6_login.controller;

import com.example.mongodb_crud_check6_login.model.Book;
import com.example.mongodb_crud_check6_login.model.CustomUserCreateReq;
import com.example.mongodb_crud_check6_login.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    @RolesAllowed({"ROLE_USER", "ROLE_ADMIN"})
    public ResponseEntity getAllBook() {
        return ResponseEntity.ok(bookService.getAllBook());
    }

    @PostMapping
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity addBook(@RequestBody Book bookCreateReq) {
        Book book = bookService.save(bookCreateReq);
        URI uri = URI.create("/book/" + book.getId());

        return ResponseEntity.created(uri).body(book);
    }

    @PutMapping
    public ResponseEntity updateBook(@RequestBody Book bookUpdateReq) {
        Book book = bookService.update(bookUpdateReq);

        if (book == null)
            return ResponseEntity.badRequest().body("Book id not found");

        return ResponseEntity.ok(book);
    }

    @DeleteMapping
    public ResponseEntity deleteBook (@RequestParam("id") String bookId) {
        return bookService.delete(bookId)
                ? ResponseEntity.ok().build()
                : ResponseEntity.badRequest().body("Book id not found");
    }
}
