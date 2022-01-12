package com.example.logisticsinventory.data.repository;

import com.example.logisticsinventory.data.model.Inventory;
import com.example.logisticsinventory.data.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Inventory findByProduct(Product product);
}
