package com.inventory.management.inventorymanager.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "vendors")
public class Vendor {

    @Id
    private String vendorId;
    private String vendorName;
    private long vendorContact;

    @OneToMany(mappedBy = "productCompany", cascade = CascadeType.PERSIST)
    private List<Product> products;

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public long getVendorContact() {
        return vendorContact;
    }

    public void setVendorContact(long vendorContact) {
        this.vendorContact = vendorContact;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
