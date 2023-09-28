package com.example.netshoeswebscrapping.exceptionHandlers;


import com.example.netshoeswebscrapping.exceptions.InvalidUrlException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(InvalidUrlException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidUrlException(InvalidUrlException exception) {
        Map<String, Object> error = new HashMap<>();
        error.put("message", exception.message);
        error.put("status", exception.statusCode);
        return ResponseEntity.status(exception.statusCode).body(error);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidUrlException(IOException exception) {
        Map<String, Object> error = new HashMap<>();
        error.put("message", exception.getMessage());
        error.put("status", 500);
        return ResponseEntity.status(500).body(error);
    }
}