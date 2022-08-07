package com.example.mongodb_crud_check6_login.repository;

import com.example.mongodb_crud_check6_login.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends MongoRepository<Book, String> {

}
