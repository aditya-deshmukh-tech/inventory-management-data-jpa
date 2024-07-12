package com.inventory.management.inventorymanager.controller;

import com.inventory.management.inventorymanager.controller.abstractcontroller.AbstractController;
import com.inventory.management.inventorymanager.models.Category;
import com.inventory.management.inventorymanager.services.dao.CategoryDAO;
import com.inventory.management.inventorymanager.services.dao.abstractdao.DAOInterface;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController extends AbstractController<Category, Integer> {

    private CategoryDAO categoryDAO;

    public CategoryController(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    protected DAOInterface<Category, Integer> getAbstractDAO() {
        return categoryDAO;
    }
}
