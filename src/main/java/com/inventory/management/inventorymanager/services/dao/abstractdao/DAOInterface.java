package com.inventory.management.inventorymanager.services.dao.abstractdao;

import java.util.List;

public interface DAOInterface<T, ID> {
    List<T> findAll();

    T findById(ID id);

    T save(T t);

    T update(T t);

    void deleteById(ID id);
}
