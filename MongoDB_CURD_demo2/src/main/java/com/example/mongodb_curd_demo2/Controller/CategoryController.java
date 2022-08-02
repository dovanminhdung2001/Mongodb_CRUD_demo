package com.example.mongodb_curd_demo2.Controller;

import com.example.mongodb_curd_demo2.Repository.BookRepository;
import com.example.mongodb_curd_demo2.Repository.CategoryRepository;
import com.example.mongodb_curd_demo2.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    BookRepository bookRepository;

    @PutMapping("/categoryies")
    public ResponseEntity<Category> createCategory (@RequestBody Category category) {
        try {
            Category category2 = categoryRepository.save(new Category(category.getName()))  ;
            return new ResponseEntity<>(category2, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/categoryies")
    public ResponseEntity<List<Category>> findAllCategory (@RequestParam(required = false) String name) {
        try {
            List<Category> categories = new ArrayList<>(name == null
                    ? categoryRepository.findAll()
                    : categoryRepository.findByNameContaining(name));
            return categories.isEmpty()
                    ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                    : new ResponseEntity<>(categories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/categoryies/{id}")
    public ResponseEntity<Category> findCategoryById (@PathVariable("id") String id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        return categoryOptional.isPresent()
                ? new ResponseEntity<>(categoryOptional.get(), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/categoryies/{id}")
    public ResponseEntity<Category> updateCategory (@PathVariable("id") String id, @RequestBody Category category) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            Category category2 = categoryOptional.get();
            category2.setName(category.getName());
            return new ResponseEntity<>(categoryRepository.save(category2), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/categoryies/{id}")
    public ResponseEntity<HttpStatus> deleteCategory (@PathVariable("id") String id) {
        try {
            bookRepository.deleteAllByCategoryId(id);
            categoryRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/categoryies")
    public ResponseEntity<HttpStatus> deleteAllCategory() {
        try {
            bookRepository.deleteAll();
            categoryRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}