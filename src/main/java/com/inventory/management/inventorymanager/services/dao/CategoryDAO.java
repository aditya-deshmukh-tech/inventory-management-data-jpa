package com.inventory.management.inventorymanager.services.dao;

import com.inventory.management.inventorymanager.exception.InventoryException;
import com.inventory.management.inventorymanager.models.Category;
import com.inventory.management.inventorymanager.repositories.CategoryRepository;
import com.inventory.management.inventorymanager.services.dao.abstractdao.AbstractDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CategoryDAO extends AbstractDAO<Category, Integer> {

    private CategoryRepository categoryRepository;

    public CategoryDAO(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    protected JpaRepository<Category, Integer> getProductRepository() {
        return categoryRepository;
    }

    @Override
    public Category findById(Integer id) {
        if (categoryRepository.findById(id).isPresent())
            return categoryRepository.findById(id).get();
        else
            throw new InventoryException(HttpStatus.NOT_FOUND.value(),
                    HttpStatus.NOT_FOUND.getReasonPhrase(), "Resource not found");
    }
}
