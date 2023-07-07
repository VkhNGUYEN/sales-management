package com.training.java.spring.salesmanagement.rest;

import com.training.java.spring.salesmanagement.entity.Customer;
import com.training.java.spring.salesmanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: NguyenVK
 */
@RestController
@RequestMapping("/api")
public class CustomerRestController {
    private final CustomerService customerService;

    @Autowired
    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Expose "/customers" and return a list of customers
    @GetMapping("/customers")
    public List<Customer> findAllCustomer() {
        return customerService.findAll();
    }

    // Add mapping for GET /customers/{customerId}
    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {
        Customer theCustomer = customerService.findById(customerId);

        if (theCustomer == null) {
            throw new RuntimeException("Customer's ID not found: " + customerId);
        }

        return theCustomer;
    }

    // Add mapping for POST /customers - add new customers
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer theCustomer) {
        // Set id to 0 in case is passes an id in JSON
        // this is to force a Save of new item instead of Update
        theCustomer.setId(0);

        Customer dbCustomer = customerService.save(theCustomer);

        return dbCustomer;
    }

    // Add mapping for PUT /customers - update existing customer
    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer theCustomer) {
        Customer dbCustomer = customerService.save(theCustomer);

        return dbCustomer;
    }

    // Add mapping for DELETE /customers/{customerId} - delete existing customer
    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {
        Customer tempCustomer = customerService.findById(customerId);

        // Throw exception if database is null
        if (tempCustomer == null) {
            throw new RuntimeException("Customer's ID not found: " + customerId);
        }

        customerService.deleteById(customerId);

        return "Delete customer's ID: " + customerId;
    }

}














