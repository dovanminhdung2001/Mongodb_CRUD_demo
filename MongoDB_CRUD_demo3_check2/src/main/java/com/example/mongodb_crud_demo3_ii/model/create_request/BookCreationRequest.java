package com.example.mongodb_crud_demo3_ii.model.create_request;

import lombok.Data;

@Data
public class BookCreationRequest {
    private String name;
    private boolean published;
    private String authorId;
    private String categoryId;
}
