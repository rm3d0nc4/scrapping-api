package com.example.netshoeswebscrapping.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Product {
    private String title;
    private Double price;
    private String imageUrl;
    private String description;
}
