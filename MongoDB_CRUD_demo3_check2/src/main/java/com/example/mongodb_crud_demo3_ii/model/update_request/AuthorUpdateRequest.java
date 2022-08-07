package com.example.mongodb_crud_demo3_ii.model.update_request;

import com.example.mongodb_crud_demo3_ii.model.create_request.AuthorCreationRequest;
import lombok.Data;

@Data
public class AuthorUpdateRequest extends AuthorCreationRequest {
    private String id;
}
