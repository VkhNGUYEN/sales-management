package com.training.java.spring.salesmanagement.dao;

import com.training.java.spring.salesmanagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: NguyenVK
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}

