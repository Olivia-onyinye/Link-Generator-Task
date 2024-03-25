package com.company.demo.controllers;

import com.company.demo.dtos.InvoiceDto;
import com.company.demo.services.InvoiceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/invoice")
public class InvoiceController {
    private final InvoiceService invoiceService;
    @PostMapping("/create")
    public ResponseEntity<String> createAnInvoice(@Valid @RequestBody InvoiceDto invoiceDto){
        invoiceService.createInvoice(invoiceDto);
        return new ResponseEntity<>("Invoice has been created and saved successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{invoiceNo}")
    public ResponseEntity<?> viewInvoice (@PathVariable String invoiceNo){
        return ResponseEntity.ok(invoiceService.getByInvoiceNo(invoiceNo));
    }

}
