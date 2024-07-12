package com.inventory.management.inventorymanager.services.dao;

import com.inventory.management.inventorymanager.exception.InventoryException;
import com.inventory.management.inventorymanager.models.Product;
import com.inventory.management.inventorymanager.repositories.ProductRepository;
import com.inventory.management.inventorymanager.services.dao.abstractdao.AbstractDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ProductDAO extends AbstractDAO<Product, String> {

    private ProductRepository productRepository;

    public ProductDAO(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    protected JpaRepository<Product, String> getProductRepository() {
        return productRepository;
    }

    @Override
    public Product findById(String id) {
        if (productRepository.findById(id).isPresent())
            return productRepository.findById(id).get();
        else
            throw new InventoryException(HttpStatus.NOT_FOUND.value(),
                    HttpStatus.NOT_FOUND.getReasonPhrase(), "Resource not found");
    }
}
