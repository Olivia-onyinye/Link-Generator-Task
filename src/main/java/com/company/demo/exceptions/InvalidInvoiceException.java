package com.company.demo.exceptions;

public class InvalidInvoiceException extends RuntimeException{

    public InvalidInvoiceException(String message) {

        super(message);
    }
}
