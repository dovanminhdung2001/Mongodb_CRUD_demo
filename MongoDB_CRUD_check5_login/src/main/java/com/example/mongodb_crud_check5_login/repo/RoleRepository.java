package com.example.mongodb_crud_check5_login.repo;

import com.example.mongodb_crud_check5_login.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
     Role findByName(String roleName);
}
