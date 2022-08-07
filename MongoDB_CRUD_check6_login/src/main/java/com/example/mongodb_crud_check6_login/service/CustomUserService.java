package com.example.mongodb_crud_check6_login.service;

import com.example.mongodb_crud_check6_login.model.CustomUser;
import com.example.mongodb_crud_check6_login.model.CustomUserCreateReq;
import com.example.mongodb_crud_check6_login.model.CustomUserUpdateReq;
import com.example.mongodb_crud_check6_login.model.Role;
import com.example.mongodb_crud_check6_login.repository.CustomUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserService {
    private final CustomUserRepo repo;

    public CustomUser findByEMail(String email) {
        return repo.findByEmail(email);
    }

    public Optional<CustomUser> findById(String userId) {
        return repo.findById(userId);
    }

    public List<CustomUser> getAllUser() {
        return repo.findAll();
    }

    public CustomUser save(CustomUserCreateReq req) {
        CustomUser user = repo.findByEmail(req.getEmail());

        if (user != null)
            return null;
        if (!"ROLE_USER".equals(req.getRoleName()) && !"ROLE_ADMIN".equals(req.getRoleName()))
            return null;

        CustomUser newUser = new CustomUser(
                req.getEmail(),
                req.getPassword(),
                Role.valueOf(req.getRoleName())
        );
        return repo.save(newUser);
    }

    public CustomUser update(CustomUserUpdateReq req) {
        Optional<CustomUser> userOptional = repo.findById(req.getId());
        CustomUser user = repo.findByEmail(req.getEmail());

        if (userOptional.isEmpty()
                || user!= null
                || (!"ROLE_USER".equals(req.getRoleName()) && !"ROLE_ADMIN".equals(req.getRoleName()))
        )
            return null;

        BeanUtils.copyProperties(req, user);
        user.setRole(Role.valueOf(req.getRoleName()));
        return repo.save(user);
    }

    public boolean  delete(String userId) {
        Optional<CustomUser> userOptional = repo.findById(userId);

        if (userOptional.isEmpty())
            return false;

        repo.delete(userOptional.get());
        return true;
    }
}
