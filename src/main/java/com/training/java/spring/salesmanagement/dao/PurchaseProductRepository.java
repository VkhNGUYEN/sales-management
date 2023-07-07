package com.training.java.spring.salesmanagement.dao;

import com.training.java.spring.salesmanagement.entity.PurchaseProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: NguyenVK
 */
public interface PurchaseProductRepository extends JpaRepository<PurchaseProduct, Integer> {
    List<PurchaseProduct> findPurchaseProductsByProductId(int theId);

    List<PurchaseProduct> findPurchaseProductsByInvoiceId(int theId);
}
