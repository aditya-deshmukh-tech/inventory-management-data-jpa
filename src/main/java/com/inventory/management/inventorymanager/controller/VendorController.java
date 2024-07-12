package com.inventory.management.inventorymanager.controller;

import com.inventory.management.inventorymanager.controller.abstractcontroller.AbstractController;
import com.inventory.management.inventorymanager.models.Vendor;
import com.inventory.management.inventorymanager.services.dao.VendorDAO;
import com.inventory.management.inventorymanager.services.dao.abstractdao.DAOInterface;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendors")
public class VendorController extends AbstractController<Vendor, String> {

    private VendorDAO vendorDAO;

    public VendorController(VendorDAO vendorDAO) {
        this.vendorDAO = vendorDAO;
    }

    @Override
    protected DAOInterface<Vendor, String> getAbstractDAO() {
        return vendorDAO;
    }
}
