package com.training.java.spring.salesmanagement.rest;

import com.training.java.spring.salesmanagement.entity.Invoice;
import com.training.java.spring.salesmanagement.entity.PurchaseProduct;
import com.training.java.spring.salesmanagement.service.PurchaseProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: NguyenVK
 */
@RestController
@RequestMapping("/api")
public class PurchaseProductRestController {
    private final PurchaseProductService purchaseProductService;

    @Autowired
    public PurchaseProductRestController(PurchaseProductService purchaseProductService) {
        this.purchaseProductService = purchaseProductService;
    }

    // Add mapping for GET /purchase-products/products/{productId}
    @GetMapping("/purchase-products/products/{productId}")
    public List<PurchaseProduct> getPurchaseProductsByProductId(@PathVariable int productId) {
        List<PurchaseProduct> thePurchaseProduct = purchaseProductService.findPurchaseProductsByProductId(productId);

        if (thePurchaseProduct == null) {
            throw new RuntimeException("Customer's ID not found: " + productId);
        }

        return thePurchaseProduct;
    }

    // Add mapping for GET /purchase-products/invoices/{invoiceId}
    @GetMapping("/purchase-products/invoices/{invoiceId}")
    public List<PurchaseProduct> getPurchaseProductsByInvoiceId(@PathVariable int invoiceId) {
        List<PurchaseProduct> thePurchaseProduct = purchaseProductService.findPurchaseProductsByInvoiceId(invoiceId);

        if (thePurchaseProduct == null) {
            throw new RuntimeException("Customer's ID not found: " + invoiceId);
        }

        return thePurchaseProduct;
    }
}
