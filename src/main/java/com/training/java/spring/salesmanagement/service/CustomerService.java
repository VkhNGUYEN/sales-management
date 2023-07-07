package com.training.java.spring.salesmanagement.service;

import com.training.java.spring.salesmanagement.entity.Customer;

import java.util.List;

/**
 * @author: NguyenVK
 */
public interface CustomerService {
    List<Customer> findAll();

    Customer save(Customer theCustomer);

    Customer findById(int theId);

    void deleteById(int theId);
}
