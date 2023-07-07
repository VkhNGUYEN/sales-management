package com.training.java.spring.salesmanagement.service;

import com.training.java.spring.salesmanagement.entity.Customer;
import com.training.java.spring.salesmanagement.entity.Invoice;

import java.util.List;

/**
 * @author: NguyenVK
 */
public interface InvoiceService {
    List<Invoice> findAll();

    Invoice findById(int theId);

    void deleteById(int theId);

    List<Invoice> findInvoicesByCustomerId(int theId);

}
