package com.example.mongodb_crud_check5_login.api;

import com.example.mongodb_crud_check5_login.model.Product;
import com.example.mongodb_crud_check5_login.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductApi {

    @Autowired private ProductRepository repo;

    @PostMapping
    @RolesAllowed("ROLE_EDITOR")
    public ResponseEntity<Product> create(@RequestBody @Valid Product product) {
        Product savedProduct = repo.save(product);
        URI productURI = URI.create("/products/" + savedProduct.getId());
        return ResponseEntity.created(productURI).body(savedProduct);
    }

    @GetMapping
    @RolesAllowed({"ROLE_CUSTOMER", "ROLE_EDITOR"})
    public List<Product> list() {
        return repo.findAll();
    }
}
