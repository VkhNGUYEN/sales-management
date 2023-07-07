package com.training.java.spring.salesmanagement.rest;

import com.training.java.spring.salesmanagement.entity.Invoice;
import com.training.java.spring.salesmanagement.entity.Product;
import com.training.java.spring.salesmanagement.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: NguyenVK
 */
@RestController
@RequestMapping("/api")
public class InvoiceRestController {
    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceRestController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    // Expose "/invoices" and return a list of customers
    @GetMapping("/invoices")
    public List<Invoice> findAllInvoice() {
        return invoiceService.findAll();
    }

    // Add mapping for GET /invoices/{invoiceId}
    @GetMapping("/invoices/{invoiceId}")
    public Invoice getInvoice(@PathVariable int invoiceId) {
        Invoice theInvoice = invoiceService.findById(invoiceId);

        if (theInvoice == null) {
            throw new RuntimeException("Invoice's ID not found: " + invoiceId);
        }

        return theInvoice;
    }

    // Add mapping for GET /invoices/customers/{customerId}
    @GetMapping("/invoices/customers/{customerId}")
    public List<Invoice> getInvoicesByCustomerId(@PathVariable int customerId) {
        List<Invoice> theInvoice = invoiceService.findInvoicesByCustomerId(customerId);

        if (theInvoice == null) {
            throw new RuntimeException("Customer's ID not found: " + customerId);
        }

        return theInvoice;
    }

    // Add mapping for DELETE /invoices/{invoiceId} - delete existing invoice
    @DeleteMapping("/invoices/{invoiceId}")
    public String deleteInvoice(@PathVariable int invoiceId) {
        Invoice tempInvoice = invoiceService .findById(invoiceId);

        // Throw exception if database is null
        if (tempInvoice == null) {
            throw new RuntimeException("Invoice's ID not found: " + invoiceId);
        }

        invoiceService.deleteById(invoiceId);

        return "Delete invoice's ID: " + invoiceId;
    }
}
