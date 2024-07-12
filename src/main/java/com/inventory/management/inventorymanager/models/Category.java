package com.inventory.management.inventorymanager.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryId;
    private String categoryName;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "prod_cat_relation",
            joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "categoryId"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "productId")
    )
    private Set<Product> products;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
