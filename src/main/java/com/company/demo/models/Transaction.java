package com.company.demo.models;

import com.company.demo.enums.TransactionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "transaction_tb")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long id;

    private String invoiceNumber;

    @Column(name = "trans_type", nullable = false)
    @NotNull(message = "Transaction type number is required")
    @Enumerated(EnumType.STRING)
    private TransactionType typeOfTrans;

    private String transactionLink;

    public Transaction(String invoiceNumber, TransactionType transactionType, String paymentLink) {
    }
}
