package com.example.mongodb_crud_check5_login.service;

import com.example.mongodb_crud_check5_login.model.Role;
import com.example.mongodb_crud_check5_login.model.User;
import com.example.mongodb_crud_check5_login.model.createReq.UserCreationRequest;
import com.example.mongodb_crud_check5_login.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired private UserRepository repo;
    @Autowired private RoleService roleService;
    @Autowired private PasswordEncoder passwordEncoder;

    public User saveUser(UserCreationRequest request) {
        Role role = roleService.findByName(request.getRoleName());
        Optional userOptional = repo.findByEmail(request.getEmail());

        if (role == null || userOptional.isPresent())
            return null;

        String rawPassword = request.getPassword();
        String encodedPassword = passwordEncoder.encode(rawPassword);
        User user = new User(request.getEmail(), encodedPassword);

        return repo.save(user);
    }

    public List<User> getAllUser() {
        return repo.findAll();
    }

    public void deleteUser(String userId) {
        User user = repo.findById(userId).get();

        if (user != null)
            repo.delete(user);

        return;
    }
}
