package com.company.demo.services;

import com.company.demo.dtos.InvoiceDto;
import com.company.demo.dtos.InvoiceResponseDto;

public interface InvoiceService {

    void createInvoice(InvoiceDto invoiceDto);

    InvoiceResponseDto getByInvoiceNo(String invoiceNumber);
}

