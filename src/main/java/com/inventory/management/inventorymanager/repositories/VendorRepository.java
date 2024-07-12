package com.inventory.management.inventorymanager.repositories;

import com.inventory.management.inventorymanager.models.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, String> {
}
