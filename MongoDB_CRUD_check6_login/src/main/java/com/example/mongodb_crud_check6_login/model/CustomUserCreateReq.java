package com.example.mongodb_crud_check6_login.model;

import lombok.Data;

@Data
public class CustomUserCreateReq {
    private String email;
    private String password;
    private String roleName;
}
