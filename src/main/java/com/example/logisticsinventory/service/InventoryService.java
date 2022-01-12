package com.example.logisticsinventory.service;

import com.example.logisticsinventory.data.model.Inventory;
import com.example.logisticsinventory.data.model.Product;
import com.example.logisticsinventory.service.dto.InventoryDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface InventoryService {
    Inventory createInventoryItem(InventoryDto inventory);
    Inventory editInventoryItem(InventoryDto inventory);
    void deleteInventoryItem(Product product);
    List<Inventory> getAllInventory();

}
