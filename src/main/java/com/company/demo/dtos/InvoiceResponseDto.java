package com.company.demo.dtos;

import com.company.demo.exceptions.ResourceNotFoundException;
import com.company.demo.models.Customer;
import com.company.demo.models.Invoice;
import com.company.demo.repositories.CustomerRepository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InvoiceResponseDto {

    private String invoiceNumber;
    private String customerName;
    private BigDecimal InvoiceAmount;
    private String serviceProvided;


}
