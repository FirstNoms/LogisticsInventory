package com.example.logisticsinventory.service;

import com.example.logisticsinventory.data.model.Inventory;
import com.example.logisticsinventory.data.model.Product;
import com.example.logisticsinventory.data.repository.InventoryRepository;
import com.example.logisticsinventory.service.dto.InventoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService{

    private final InventoryRepository inventoryRepository;

    @Override
    public Inventory createInventoryItem(InventoryDto inventory) {
        Inventory newInventory = new Inventory();
        newInventory.setProduct(inventory.getProduct());
        newInventory.setQuantity(inventory.getQuantity());
        newInventory.setLastModifiedDate(LocalDateTime.now());
        return inventoryRepository.save(newInventory);
    }

    @Override
    public Inventory editInventoryItem(InventoryDto inventoryDto) {
        Inventory inventory = inventoryRepository.findByProduct(inventoryDto.getProduct());
        inventory.setQuantity(inventoryDto.getQuantity());
        return inventoryRepository.save(inventory);
    }

    @Override
    public void deleteInventoryItem(Product product) {
        Inventory inventory = inventoryRepository.findByProduct(product);
        inventoryRepository.delete(inventory);
    }

    @Override
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }
}
