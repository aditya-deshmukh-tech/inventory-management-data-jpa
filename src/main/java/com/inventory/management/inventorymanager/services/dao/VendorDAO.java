package com.inventory.management.inventorymanager.services.dao;

import com.inventory.management.inventorymanager.exception.InventoryException;
import com.inventory.management.inventorymanager.models.Vendor;
import com.inventory.management.inventorymanager.repositories.VendorRepository;
import com.inventory.management.inventorymanager.services.dao.abstractdao.AbstractDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class VendorDAO extends AbstractDAO<Vendor, String> {

    private VendorRepository vendorRepository;

    public VendorDAO(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @Override
    protected JpaRepository<Vendor, String> getProductRepository() {
        return vendorRepository;
    }

    @Override
    public Vendor findById(String id) {
        if (vendorRepository.findById(id).isPresent())
            return vendorRepository.findById(id).get();
        else
            throw new InventoryException(HttpStatus.NOT_FOUND.value(),
                    HttpStatus.NOT_FOUND.getReasonPhrase(), "Resource not found");
    }
}
