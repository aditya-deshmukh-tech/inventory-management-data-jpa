package com.inventory.management.inventorymanager.repositories;

import com.inventory.management.inventorymanager.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
