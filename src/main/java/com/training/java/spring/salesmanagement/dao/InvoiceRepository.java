package com.training.java.spring.salesmanagement.dao;

import com.training.java.spring.salesmanagement.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: NguyenVK
 */
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
    List<Invoice> findInvoicesByCustomerId(int theId);
}

