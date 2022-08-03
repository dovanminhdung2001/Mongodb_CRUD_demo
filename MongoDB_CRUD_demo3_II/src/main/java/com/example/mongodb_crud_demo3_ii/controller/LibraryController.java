package com.example.mongodb_crud_demo3_ii.controller;

import com.example.mongodb_crud_demo3_ii.model.Author;
import com.example.mongodb_crud_demo3_ii.model.Book;
import com.example.mongodb_crud_demo3_ii.model.Category;
import com.example.mongodb_crud_demo3_ii.model.create_request.AuthorCreationRequest;
import com.example.mongodb_crud_demo3_ii.model.create_request.BookCreationRequest;
import com.example.mongodb_crud_demo3_ii.model.create_request.CategoryCreationRequest;
import com.example.mongodb_crud_demo3_ii.model.update_request.AuthorUpdateRequest;
import com.example.mongodb_crud_demo3_ii.model.update_request.BookUpdateRequest;
import com.example.mongodb_crud_demo3_ii.model.update_request.CategoryUpdateRequest;
import com.example.mongodb_crud_demo3_ii.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class LibraryController {
    private final LibraryService libraryService;

    @GetMapping("/author")
    public ResponseEntity findAllAuthor() {
        return ResponseEntity.ok(libraryService.findAllAuthor());
    }

    @GetMapping("/category")
    public ResponseEntity finddAllCategory() {
        return ResponseEntity.ok(libraryService.findAllCategory());
    }

    @GetMapping("/book")
    public ResponseEntity findAllBook( ) {
        return   ResponseEntity.ok(libraryService.findAllBook()) ;
    }

    @PostMapping("/author")
    public ResponseEntity<Author> createAuthor(@RequestBody AuthorCreationRequest request) {
        return ResponseEntity.ok(libraryService.createAuthor(request));
    }

    @PostMapping("/category")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryCreationRequest request) {
        return ResponseEntity.ok(libraryService.createCategory(request));
    }

    @PostMapping("/book")
    public ResponseEntity<Book> createBook(@RequestBody BookCreationRequest request) {
        return ResponseEntity.ok(libraryService.createBook(request));
    }

    @PutMapping("/author")
    public ResponseEntity<Author> updateAuthor(@RequestBody AuthorUpdateRequest request) {
        return ResponseEntity.ok(libraryService.updateAuthor(request));
    }

    @PutMapping("/category")
    public ResponseEntity<Category> updateCategory(@RequestBody CategoryUpdateRequest request) {
        return ResponseEntity.ok(libraryService.updateCategory(request));
    }

    @PutMapping("/book")
    public ResponseEntity<Book> updateBook(@RequestBody BookUpdateRequest request) {
        return ResponseEntity.ok(libraryService.updateBook(request));
    }

    @DeleteMapping("/author/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable("id") String id) {
        libraryService.deleteAuthor(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") String id) {
        libraryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") String id) {
        libraryService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
 }
