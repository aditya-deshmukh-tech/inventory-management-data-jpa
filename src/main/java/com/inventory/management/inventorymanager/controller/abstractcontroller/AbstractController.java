package com.inventory.management.inventorymanager.controller.abstractcontroller;

import com.inventory.management.inventorymanager.services.dao.abstractdao.DAOInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class AbstractController<T, ID> {

    private DAOInterface<T, ID> abstractDAO;

    protected abstract DAOInterface<T, ID> getAbstractDAO();

    @GetMapping("/all")
    public ResponseEntity<?> findAllProducts() {
        return ResponseEntity.ok(getAbstractDAO().findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findProductById(@PathVariable ID id) {
        return ResponseEntity.ok(getAbstractDAO().findById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody T t) {
        return ResponseEntity.status(HttpStatus.CREATED).body(getAbstractDAO().save(t));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateProduct(@RequestBody T t) {
        return ResponseEntity.ok(getAbstractDAO().update(t));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable ID id) {
        getAbstractDAO().deleteById(id);
        return ResponseEntity.ok().build();
    }
}
