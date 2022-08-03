package com.example.mongodb_crud_demo3_ii.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Author {
    @Id
    private String id;
    private String name;
}
