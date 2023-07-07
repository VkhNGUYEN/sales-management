package com.training.java.spring.salesmanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

/**
 * @author: NguyenVK
 */
@Entity
@Table(name = "purchase_product")
@IdClass(PurchaseProductId.class)
public class PurchaseProduct {
    // Define fields
    @Id
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "invoice_id")
    @JsonBackReference
    private Invoice invoice;

    @Column(name = "purchase_product_quantity")
    private int quantity;

    @Id
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;

    @Column(name = "total_price")
    private int totalPrice;

    private PurchaseProduct() {

    }

    public PurchaseProduct(int quantity, int totalPrice) {
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "PurchaseProduct{" +
                "quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
