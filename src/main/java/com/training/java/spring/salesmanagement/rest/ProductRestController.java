package com.training.java.spring.salesmanagement.rest;

import com.training.java.spring.salesmanagement.entity.Product;
import com.training.java.spring.salesmanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: NguyenVK
 */
@RestController
@RequestMapping("/api")
public class ProductRestController {
    private final ProductService productService;

    @Autowired
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    // Expose "/products" and return a list of products
    @GetMapping("/products")
    public List<Product> findAllProduct() {
        return productService.findAll();
    }

    // Add mapping for GET /products/{productId}
    @GetMapping("/products/{productId}")
    public Product getProduct(@PathVariable int productId) {
        Product theProduct = productService.findById(productId);

        if (theProduct == null) {
            throw new RuntimeException("Product's ID not found: " + productId);
        }

        return theProduct;
    }

    // Add mapping for POST /products - add new products
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product theProduct) {
        // Set id to 0 in case is passes an id in JSON
        // this is to force a Save of new item instead of Update
        theProduct.setId(0);

        Product dbProduct = productService.save(theProduct);

        return dbProduct;
    }

    // Add mapping for PUT /products - update existing product
    @PutMapping("/products")
    public Product updateProduct(@RequestBody Product theProduct) {
        Product dbProduct = productService.save(theProduct);

        return dbProduct;
    }

    // Add mapping for DELETE /products/{productId} - delete existing product
    @DeleteMapping("/products/{productId}")
    public String deleteProduct(@PathVariable int productId) {
        Product tempProduct = productService.findById(productId);

        // Throw exception if database is null
        if (tempProduct == null) {
            throw new RuntimeException("Product's ID not found: " + productId);
        }

        productService.deleteById(productId);

        return "Delete product's ID: " + productId;
    }
}
