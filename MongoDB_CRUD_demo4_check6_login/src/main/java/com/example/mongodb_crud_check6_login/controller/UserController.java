package com.example.mongodb_crud_check6_login.controller;


import com.example.mongodb_crud_check6_login.model.CustomUser;
import com.example.mongodb_crud_check6_login.model.CustomUserCreateReq;
import com.example.mongodb_crud_check6_login.model.CustomUserUpdateReq;
import com.example.mongodb_crud_check6_login.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private CustomUserService userService;

    @GetMapping
    public ResponseEntity getAllUser () {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @PostMapping
    public ResponseEntity addUser (@RequestBody CustomUserCreateReq req) {
        CustomUser user = userService.save(req);

        if (user == null)
            return ResponseEntity.badRequest().body("Invalid information");

        URI uri = URI.create("/user/" + user.getId());

        return ResponseEntity.created(uri).body(user);
    }

    @PutMapping
    public ResponseEntity updateUser(@RequestBody CustomUserUpdateReq req) {
        CustomUser user = userService.update(req);

        if (user == null)
            return ResponseEntity.badRequest().body("Invalid information");

        return ResponseEntity.ok(user);
    }

    @DeleteMapping
    public ResponseEntity deleteUser (@RequestParam("id") String userId) {
        return userService.delete(userId)
                ? ResponseEntity.ok().build()
                : ResponseEntity.badRequest().body("User id not found");
    }

}
