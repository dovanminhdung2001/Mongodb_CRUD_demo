package com.example.mongodb_crud_check6_login.model;

import lombok.Data;

@Data
public class CustomUserUpdateReq {
    private String id;
    private String email;
    private String password;
    private String roleName;
}
