package com.training.java.spring.salesmanagement.dao;

import com.training.java.spring.salesmanagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: NguyenVK
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
