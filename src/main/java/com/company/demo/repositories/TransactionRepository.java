package com.company.demo.repositories;

import com.company.demo.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    boolean existsByInvoiceNumber(String invoiceNumber);
    Optional<Transaction> findByInvoiceNumber (String invoiceNumber);

}
