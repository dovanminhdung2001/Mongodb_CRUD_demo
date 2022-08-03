package com.example.mongodb_crud_demo3_ii.repository;

import com.example.mongodb_crud_demo3_ii.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
}
