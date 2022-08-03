package com.example.mongodb_crud_demo3_ii.repository;

import com.example.mongodb_crud_demo3_ii.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findAllByAuthorId (String id);
    List<Book> findAllByCategoryId (String id);
}
