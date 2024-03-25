package com.company.demo.repositories;

import com.company.demo.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    boolean existsByInvoiceNumber(String invoiceNumber);

    Optional<Invoice> findByInvoiceNumber(String invoiceNumber);
}
