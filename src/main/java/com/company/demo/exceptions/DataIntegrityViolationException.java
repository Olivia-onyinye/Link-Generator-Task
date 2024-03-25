package com.company.demo.exceptions;

public class DataIntegrityViolationException extends RuntimeException{

    public DataIntegrityViolationException(String message) {


        super(message);
    }
}
