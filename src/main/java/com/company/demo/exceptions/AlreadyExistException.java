package com.company.demo.exceptions;

public class AlreadyExistException extends RuntimeException {
    public AlreadyExistException(String message) {

        super(message);
    }
}
