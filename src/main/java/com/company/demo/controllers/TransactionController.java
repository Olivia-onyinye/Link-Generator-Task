package com.company.demo.controllers;

import com.company.demo.exceptions.AlreadyExistException;
import com.company.demo.models.Transaction;
import com.company.demo.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping("/save")
    public ResponseEntity<String> saveTransaction(@RequestBody Transaction transaction) {
            transactionService.saveTransaction(transaction);
        return new ResponseEntity<>("Transaction saved successfully.", HttpStatus.CREATED);
    }

    @GetMapping("/view/{invoiceNumber}")
    public ResponseEntity<Transaction> viewTransaction(@PathVariable String invoiceNumber){
        return new ResponseEntity<>(transactionService.viewTransaction(invoiceNumber), HttpStatus.OK);
    }

    @GetMapping("/generate-view-link/{invoiceNumber}")
    public ResponseEntity<String> generateInvoiceViewLink(@PathVariable String invoiceNumber) {
        return new ResponseEntity<>(transactionService.generateInvoiceViewLink(invoiceNumber), HttpStatus.OK);
    }

    @GetMapping("/generate-payment-link/{invoiceNumber}")
    public ResponseEntity<String> generateInvoicePaymentLink(@PathVariable String invoiceNumber) {
        return new ResponseEntity<>(transactionService.generateInvoicePaymentLink(invoiceNumber), HttpStatus.OK);
    }



}
