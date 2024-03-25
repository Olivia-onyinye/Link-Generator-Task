package com.company.demo.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {

    @NotBlank(message = "Invoice number is required")
    private String invoiceNumber;
    @NotNull(message = "Invoice amount is required")
    private BigDecimal InvoiceAmount;
    @NotBlank(message = "Service provided or item purchased should be inputted")
    private String serviceProvided;
    private Long customerId;


}
