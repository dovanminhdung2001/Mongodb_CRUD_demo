package com.example.mongodb_curd_demo2.Repository;

import com.example.mongodb_curd_demo2.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CategoryRepository extends MongoRepository<Category, String> {
    List<Category> findByNameContaining (String name);
}
