package com.backend.backend.exception;

public class DataNotFoundException extends RuntimeException {

 

    public DataNotFoundException(Long id) {
        super("Data id "+ id + " tidak ditemukan");
    }

}
