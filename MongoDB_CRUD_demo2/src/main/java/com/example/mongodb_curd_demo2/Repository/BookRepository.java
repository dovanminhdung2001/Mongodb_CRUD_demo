package com.example.mongodb_curd_demo2.Repository;

import com.example.mongodb_curd_demo2.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {
    List<Book>  findByNameContaining (String name);
    List<Book> findByPublished (boolean published);
    boolean deleteAllByCategoryId(String categoryId);
}
