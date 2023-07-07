package com.training.java.spring.salesmanagement.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: NguyenVK
 */
@Entity
@Table(name = "product")
public class Product {
    // Define fields
    @Id
    @Column(name = "product_id")
    private int id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_unit")
    private String productUnit;

    @Column(name = "product_price")
    private int price;

    @OneToMany(mappedBy = "product",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JsonManagedReference
    private List<PurchaseProduct> purchaseProducts;

    private Product() {

    }

    public Product(String productName, String productUnit, int price) {
        this.productName = productName;
        this.productUnit = productUnit;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productUnit='" + productUnit + '\'' +
                ", productPrice=" + price +
                '}';
    }

    public List<PurchaseProduct> getPurchaseProducts() {
        return purchaseProducts;
    }

    public void setPurchaseProducts(List<PurchaseProduct> purchaseProducts) {
        this.purchaseProducts = purchaseProducts;
    }

    public void add(PurchaseProduct tempPurchaseProduct) {
        if (purchaseProducts == null) {
            purchaseProducts = new ArrayList<>();
        }

        this.purchaseProducts.add(tempPurchaseProduct);
    }
}
