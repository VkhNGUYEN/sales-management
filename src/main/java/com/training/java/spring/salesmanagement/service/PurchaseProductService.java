package com.training.java.spring.salesmanagement.service;

import com.training.java.spring.salesmanagement.entity.PurchaseProduct;

import java.util.List;

/**
 * @author: NguyenVK
 */
public interface PurchaseProductService {
    List<PurchaseProduct> findPurchaseProductsByProductId(int theId);

    List<PurchaseProduct> findPurchaseProductsByInvoiceId(int theId);
}
