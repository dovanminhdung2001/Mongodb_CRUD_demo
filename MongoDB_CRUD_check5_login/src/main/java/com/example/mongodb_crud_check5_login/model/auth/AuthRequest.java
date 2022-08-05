package com.example.mongodb_crud_check5_login.model.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequest {
    @NotNull @Email @Length(min = 5, max = 50)
    private  String email;

    @NotNull @Length(min = 5, max = 100)
    private  String password;
}
