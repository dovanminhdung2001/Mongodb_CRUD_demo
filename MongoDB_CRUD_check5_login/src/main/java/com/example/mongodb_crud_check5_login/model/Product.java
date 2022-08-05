package com.example.mongodb_crud_check5_login.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Document
@NoArgsConstructor
public class Product {
    @Id
    private String id;
    @NotNull @Length(min = 1, max = 128)
    private String name;
    private float price;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
    }
}
