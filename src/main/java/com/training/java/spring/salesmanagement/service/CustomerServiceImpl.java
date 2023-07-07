package com.training.java.spring.salesmanagement.service;

import com.training.java.spring.salesmanagement.dao.CustomerRepository;
import com.training.java.spring.salesmanagement.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author: NguyenVK
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;

    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int theId) {
        Optional<Customer> resultById = customerRepository.findById(theId);

        Customer theCustomer = null;

        if (resultById.isPresent()) {
            theCustomer = resultById.get();
        } else {
            // We didn't find the employee
            throw new RuntimeException("Did not find customer's id:" + theId);
        }

        return theCustomer;
    }

    @Override
    public Customer save(Customer theCustomer) {
        return customerRepository.save(theCustomer);
    }

    @Override
    public void deleteById(int theId) {
        customerRepository.deleteById(theId);
    }
}
