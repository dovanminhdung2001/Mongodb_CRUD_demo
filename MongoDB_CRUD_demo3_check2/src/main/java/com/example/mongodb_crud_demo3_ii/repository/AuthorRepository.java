package com.example.mongodb_crud_demo3_ii.repository;

import com.example.mongodb_crud_demo3_ii.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {
}
