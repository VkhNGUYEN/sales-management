package com.training.java.spring.salesmanagement.service;

import com.training.java.spring.salesmanagement.entity.Product;

import java.util.List;

/**
 * @author: NguyenVK
 */
public interface ProductService {
    List<Product> findAll();

    Product save(Product theProduct);

    Product findById(int theId);

    void deleteById(int theId);
}
