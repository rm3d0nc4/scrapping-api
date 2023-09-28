package com.example.netshoeswebscrapping.exceptions;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InvalidUrlException extends Exception{
    public String message;
    public Integer statusCode;
}
