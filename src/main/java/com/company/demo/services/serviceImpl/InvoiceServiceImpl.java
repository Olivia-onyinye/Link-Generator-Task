package com.company.demo.services.serviceImpl;

import com.company.demo.dtos.InvoiceDto;
import com.company.demo.dtos.InvoiceResponseDto;
import com.company.demo.exceptions.InvalidInvoiceException;
import com.company.demo.exceptions.InvoiceAlreadyExistException;
import com.company.demo.exceptions.ResourceNotFoundException;
import com.company.demo.models.Customer;
import com.company.demo.models.Invoice;
import com.company.demo.repositories.CustomerRepository;
import com.company.demo.repositories.InvoiceRepository;
import com.company.demo.services.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final CustomerRepository customerRepository;
    @Override
    public void createInvoice(InvoiceDto invoiceDto) {
        boolean existingInvoice = invoiceRepository.existsByInvoiceNumber(invoiceDto.getInvoiceNumber());
        if (existingInvoice){
            throw new InvoiceAlreadyExistException("This invoice cannot be saved as it already exists");
        }
        Customer existingCust = customerRepository.findById(invoiceDto.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer with customerId: " + invoiceDto.getCustomerId() + " not found"));

        Invoice invoice = new Invoice();
        invoice.setInvoiceNumber(invoiceDto.getInvoiceNumber());
        invoice.setInvoiceAmount(invoiceDto.getInvoiceAmount());
        invoice.setCustomerId(existingCust.getCustomerId());
        invoice.setServiceProvided(invoiceDto.getServiceProvided());
        invoice.setDealTimestamp(LocalDateTime.now());
        invoiceRepository.save(invoice);

    }

    @Override
    public InvoiceResponseDto getByInvoiceNo(String invoiceNumber) {
        Invoice invoice = invoiceRepository.findByInvoiceNumber(invoiceNumber)
                .orElseThrow(()-> new InvalidInvoiceException("This invoice does not exist"));
        Customer existingCust = customerRepository.findById(invoice.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer with customerId not found"));
        InvoiceResponseDto invoiceResponseDto = new InvoiceResponseDto();
        invoiceResponseDto.setInvoiceNumber(invoice.getInvoiceNumber());
        invoiceResponseDto.setInvoiceAmount(invoice.getInvoiceAmount());
        invoiceResponseDto.setCustomerName(existingCust.getCustomer_name());
        invoiceResponseDto.setServiceProvided(invoice.getServiceProvided());
        return invoiceResponseDto;
    }
}
