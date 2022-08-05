package com.example.mongodb_crud_check5_login.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
@ToString
@NoArgsConstructor
public class Role {
    @Id
    private String id;
    private String name;

    public Role(String name) {
        this.name = name;
    }

    public String toString() {
        return  this.name;
    }
}