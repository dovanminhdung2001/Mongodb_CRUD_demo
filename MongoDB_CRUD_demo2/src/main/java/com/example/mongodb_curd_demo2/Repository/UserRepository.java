package com.example.mongodb_curd_demo2.Repository;

import com.example.mongodb_curd_demo2.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByUserNameContaining (String name);
    List<User> findByActivated(boolean activated);


}
