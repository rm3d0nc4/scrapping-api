package com.example.netshoeswebscrapping.services;

import com.example.netshoeswebscrapping.entities.Product;
import com.example.netshoeswebscrapping.exceptions.InvalidUrlException;

import java.io.IOException;


public interface ScrappingService {
    public Product fetchProduct(String url) throws IOException, InvalidUrlException;
}
