package com.example.mongodb_crud_check6_login.service;

import com.example.mongodb_crud_check6_login.model.Book;
import com.example.mongodb_crud_check6_login.repository.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepo repo;

    public List<Book> getAllBook() {
        return repo.findAll();
    }

    public Book save(Book book) {
        return repo.save(book);
    }

    public Book update (Book book) {
        Optional<Book> bookOptional = repo.findById(book.getId());

        if (bookOptional.isEmpty())
            return null;

        return repo.save(bookOptional.get());
    }

    public boolean delete (String bookId) {
        Optional<Book> bookOptional = repo.findById(bookId);

        if (bookOptional.isEmpty())
            return false;

        repo.delete(bookOptional.get());
        return true;
    }
}
