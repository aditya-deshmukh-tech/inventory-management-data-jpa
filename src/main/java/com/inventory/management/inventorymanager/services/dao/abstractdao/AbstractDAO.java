package com.inventory.management.inventorymanager.services.dao.abstractdao;

import com.inventory.management.inventorymanager.exception.InventoryException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;

import java.util.List;

public abstract class AbstractDAO<T, ID> implements DAOInterface<T, ID>{

    private JpaRepository<T, ID> productRepository;

    protected abstract JpaRepository<T, ID> getProductRepository();

    public abstract T findById(ID id);

    public List<T> findAll() {
        return getProductRepository().findAll();
    }

    public T save(T t) {
        return getProductRepository().save(t);
    }

    public T update(T t) {
        return save(t);
    }

    public void deleteById(ID id) {
        if (getProductRepository().existsById(id))
            getProductRepository().deleteById(id);
        else
            throw new InventoryException(HttpStatus.NOT_FOUND.value(),
                    HttpStatus.NOT_FOUND.getReasonPhrase(), "Resource to delete not found");
    }
}
