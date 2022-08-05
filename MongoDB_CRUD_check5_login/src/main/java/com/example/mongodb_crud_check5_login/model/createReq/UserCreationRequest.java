package com.example.mongodb_crud_check5_login.model.createReq;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class UserCreationRequest {
    @Email  @Length(max = 50)     @NotNull
    private String email;
    @Length(min = 1, max = 64)     @NotNull
    private String password;
    private String roleName;
}
