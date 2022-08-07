package com.example.mongodb_crud_demo3_ii.model.update_request;

import com.example.mongodb_crud_demo3_ii.model.create_request.BookCreationRequest;
import lombok.Data;

@Data
public class BookUpdateRequest extends BookCreationRequest {
    private String id;
}
