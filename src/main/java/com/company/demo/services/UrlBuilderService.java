package com.company.demo.services;

public interface UrlBuilderService {

    String buildInvoiceViewUrl(String invoiceNumber, String transactionCode, int serverPort);
    String buildInvoicePaymentUrl(String invoiceNumber, String transactionCode, int serverPort);

}
