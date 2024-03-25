package com.company.demo.services.serviceImpl;

import com.company.demo.services.UrlBuilderService;

public class UrlBuilderServiceImpl implements UrlBuilderService {
    @Override
    public String buildInvoiceViewUrl(String invoiceNumber, String transactionCode, int serverPort) {
        return "https://localhost:" + serverPort + "/api/invoice?invoiceNo=" + invoiceNumber + "&transactionCode=" + transactionCode;
    }

    @Override
    public String buildInvoicePaymentUrl(String invoiceNumber, String transactionCode, int serverPort) {
        return "https://localhost:" + serverPort + "/api/transaction/payment?invoiceNo=" + invoiceNumber + "&transactionCode=" + transactionCode;
    }
}
