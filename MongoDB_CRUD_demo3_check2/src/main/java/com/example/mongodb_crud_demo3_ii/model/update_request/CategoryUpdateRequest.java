package com.example.mongodb_crud_demo3_ii.model.update_request;

import com.example.mongodb_crud_demo3_ii.model.create_request.CategoryCreationRequest;
import lombok.Data;

@Data
public class CategoryUpdateRequest extends CategoryCreationRequest {
    private String id;
}
