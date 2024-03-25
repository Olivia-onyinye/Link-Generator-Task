package com.company.demo.services;

import com.company.demo.dtos.InvoiceDto;
import com.company.demo.dtos.InvoiceResponseDto;
import com.company.demo.models.Transaction;

public interface TransactionService {
    void saveTransaction(Transaction transaction);

    Transaction viewTransaction(String invoiceNumber);
    String generateInvoiceViewLink(String invoiceNumber);
    String generateInvoicePaymentLink(String invoiceNumber);
}
