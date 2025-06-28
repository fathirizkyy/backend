package com.backend.backend.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.backend.backend.payload.ApiErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<ApiErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
    System.out.println("terpanggil");
    Map<String,String>errors=new HashMap<>();
    ex.getBindingResult().getFieldErrors().forEach(error -> {
        errors.put(error.getField(), error.getDefaultMessage());
    });
    ApiErrorResponse apiErrorResponse = new ApiErrorResponse(false, "Validation failed", errors);
    return ResponseEntity.badRequest().body(apiErrorResponse);
}

@ExceptionHandler(DataNotFoundException.class)
public ResponseEntity<ApiErrorResponse> handleDataNotFoundException(DataNotFoundException ex) {
    ApiErrorResponse apiErrorResponse = new ApiErrorResponse(false, ex.getMessage(), null);
    return new ResponseEntity<>(apiErrorResponse,HttpStatus.NOT_FOUND);
}

@ExceptionHandler(EmptyDatabaseException.class)
public ResponseEntity<ApiErrorResponse> handleEmptyDatabaseException(EmptyDatabaseException ex) {
    ApiErrorResponse apiErrorResponse = new ApiErrorResponse(false, ex.getMessage(), null);
    return new ResponseEntity<>(apiErrorResponse, HttpStatus.NOT_FOUND);
}
}