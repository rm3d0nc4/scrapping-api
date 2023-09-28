package com.example.netshoeswebscrapping.controllers;


import com.example.netshoeswebscrapping.entities.Product;
import com.example.netshoeswebscrapping.exceptions.InvalidUrlException;
import com.example.netshoeswebscrapping.services.ScrappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ScrappingController {


    @Autowired
    ScrappingService scrappingService;

    @GetMapping("/get-product")
    ResponseEntity<Product> getProduct(@RequestParam("url") String url) throws IOException, InvalidUrlException {
        Product product = scrappingService.fetchProduct(url);

        return ResponseEntity.ok(product);

    }
}
