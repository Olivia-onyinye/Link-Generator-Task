package com.company.demo.exceptions;

public class InvoiceAlreadyExistException extends RuntimeException{

    public InvoiceAlreadyExistException(String message) {

        super(message);
    }
}
