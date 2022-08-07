package com.example.mongodb_crud_check6_login.repository;

import com.example.mongodb_crud_check6_login.model.CustomUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomUserRepo extends MongoRepository<CustomUser, String> {
    CustomUser findByEmail(String email);
}
