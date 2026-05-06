package com.rafael.aprendendo_spring.infrastructure.exceptions;

public class ConflictExceptions extends RuntimeException {

    public ConflictExceptions (String message) {
        super (message);
    }

}
