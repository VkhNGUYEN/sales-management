package com.training.java.spring.salesmanagement.entity;

import java.io.Serializable;

/**
 * @author: NguyenVK
 */
public class PurchaseProductId implements Serializable {
    private Invoice invoice;

    private Product product;

    // default constructor
    private PurchaseProductId() {

    }

    public PurchaseProductId(Invoice invoice, Product product) {
        this.invoice = invoice;
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PurchaseProductId that = (PurchaseProductId) o;

        if (!invoice.equals(that.invoice)) return false;
        return product.equals(that.product);
    }

    @Override
    public int hashCode() {
        int result = invoice.hashCode();
        result = 31 * result + product.hashCode();
        return result;
    }
}
