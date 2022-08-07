package com.example.mongodb_crud_check6_login.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
public class CustomUser {
    @Id
    private String id;
    private String email;
    private String password;
    private Role role = Role.ROLE_USER;

    public CustomUser(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public CustomUser(String email, String password, String roleName) {
        this.email = email;
        this.password = password;
        this.role = Role.valueOf(roleName);
    }
}
