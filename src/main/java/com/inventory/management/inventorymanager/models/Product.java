package com.inventory.management.inventorymanager.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "products")
public class Product {

    @Id
    private String productId;
    private String productName;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Vendor productCompany;
    private String productDesc;
    private float productPrice;
    private int amtAvailable;

    @ManyToMany(mappedBy = "products", cascade = CascadeType.PERSIST)
    private Set<Category> categories;
    //letter will add mfg date, exp date


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Vendor getProductCompany() {
        return productCompany;
    }

    public void setProductCompany(Vendor productCompany) {
        this.productCompany = productCompany;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public int getAmtAvailable() {
        return amtAvailable;
    }

    public void setAmtAvailable(int amtAvailable) {
        this.amtAvailable = amtAvailable;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
