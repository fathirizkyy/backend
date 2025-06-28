package com.backend.backend.exception;

public class EmptyDatabaseException extends RuntimeException {
    

    public EmptyDatabaseException() {
        super("belum ada data di database");
    }

   

}
