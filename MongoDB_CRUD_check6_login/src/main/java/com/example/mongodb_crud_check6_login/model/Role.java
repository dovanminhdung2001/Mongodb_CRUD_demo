package com.example.mongodb_crud_check6_login.model;

public enum Role {
    ROLE_USER, ROLE_ADMIN;

    @Override
    public String toString() {
        return this.name();
    }
}
