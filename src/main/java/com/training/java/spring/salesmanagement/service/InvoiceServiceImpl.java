package com.training.java.spring.salesmanagement.service;

import com.training.java.spring.salesmanagement.dao.InvoiceRepository;
import com.training.java.spring.salesmanagement.entity.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author: NguyenVK
 */
@Service
public class InvoiceServiceImpl implements InvoiceService {
    private InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice findById(int theId) {
        Optional<Invoice> resultById = invoiceRepository.findById(theId);

        Invoice theInvoice = null;

        if (resultById.isPresent()) {
            theInvoice = resultById.get();
        } else {
            // We didn't find the employee
            throw new RuntimeException("Did not find invoice's id:" + theId);
        }

        return theInvoice;
    }

    @Override
    public void deleteById(int theId) {
        invoiceRepository.deleteById(theId);

    }

    @Override
    public List<Invoice> findInvoicesByCustomerId(int theId) {
        return invoiceRepository.findInvoicesByCustomerId(theId);
    }
}
