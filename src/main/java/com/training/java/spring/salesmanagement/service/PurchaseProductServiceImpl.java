package com.training.java.spring.salesmanagement.service;

import com.training.java.spring.salesmanagement.dao.PurchaseProductRepository;
import com.training.java.spring.salesmanagement.entity.PurchaseProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: NguyenVK
 */
@Service
public class PurchaseProductServiceImpl implements PurchaseProductService {
    private final PurchaseProductRepository purchaseProductRepository;

    @Autowired
    public PurchaseProductServiceImpl(PurchaseProductRepository purchaseProductRepository) {
        this.purchaseProductRepository = purchaseProductRepository;
    }

    @Override
    public List<PurchaseProduct> findPurchaseProductsByProductId(int theId) {
        return purchaseProductRepository.findPurchaseProductsByProductId(theId);
    }

    @Override
    public List<PurchaseProduct> findPurchaseProductsByInvoiceId(int theId) {
        return purchaseProductRepository.findPurchaseProductsByInvoiceId(theId);
    }
}
