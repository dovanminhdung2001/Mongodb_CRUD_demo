package com.example.mongodb_crud_demo3_ii.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Book {
    @Id
    private String id;
    private String name;
    private boolean published;
    @DBRef
    private Author author;
    @DBRef
    private Category category;
}
