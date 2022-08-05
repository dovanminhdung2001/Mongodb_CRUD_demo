package com.example.mongodb_crud_check5_login.api;

import com.example.mongodb_crud_check5_login.model.User;
import com.example.mongodb_crud_check5_login.model.UserDTO;
import com.example.mongodb_crud_check5_login.model.createReq.UserCreationRequest;
import com.example.mongodb_crud_check5_login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserApi {
    @Autowired private UserService service;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody @Valid UserCreationRequest request) {
        User createdUser = service.saveUser(request);
        URI uri = URI.create("/users/" + createdUser.getId());

        UserDTO userDTO = new UserDTO(createdUser.getId(), createdUser.getEmail());

        return ResponseEntity.created(uri).body(userDTO);
    }

    @GetMapping
    public ResponseEntity getALlUser() {
        return ResponseEntity.ok(service.getAllUser());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String userId) {
        service.deleteUser(userId);
        return ResponseEntity.ok().build();
    }
}
