package com.inventory.management.inventorymanager.controller;

import com.inventory.management.inventorymanager.controller.abstractcontroller.AbstractController;
import com.inventory.management.inventorymanager.models.Product;
import com.inventory.management.inventorymanager.services.dao.ProductDAO;
import com.inventory.management.inventorymanager.services.dao.abstractdao.DAOInterface;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductsController extends AbstractController<Product, String> {

    private ProductDAO productDAO;

    public ProductsController(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    protected DAOInterface<Product, String> getAbstractDAO() {
        return productDAO;
    }
}
