package com.training.java.spring.salesmanagement.service;

import com.training.java.spring.salesmanagement.dao.ProductRepository;
import com.training.java.spring.salesmanagement.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author: NguyenVK
 */
@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product theProduct) {
        return productRepository.save(theProduct);
    }

    @Override
    public Product findById(int theId) {
        Optional<Product> resultById = productRepository.findById(theId);

        Product theProduct = null;

        if (resultById.isPresent()) {
            theProduct = resultById.get();
        } else {
            // We didn't find the employee
            throw new RuntimeException("Did not find product's id:" + theId);
        }

        return theProduct;
    }

    @Override
    public void deleteById(int theId) {
        productRepository.deleteById(theId);
    }
}
