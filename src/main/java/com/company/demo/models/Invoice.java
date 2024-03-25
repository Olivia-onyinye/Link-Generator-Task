package com.company.demo.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "invoice_tb")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private Long id;

    @NotBlank(message = "Invoice number is required")
    @Column(name = "invoice_no", unique = true)
    private String invoiceNumber;

    @NotBlank(message = "Service provided or item purchased should be inputed")
    private String serviceProvided;

    @Column(name = "invoice_amount", nullable = false)
    @NotNull(message = "Invoice amount is required")
    private BigDecimal InvoiceAmount;

    @Column(name = "customerId")
    private Long customerId;

    @Column(name="invoice_timestamp")
    @CreationTimestamp
    private LocalDateTime dealTimestamp;

}
