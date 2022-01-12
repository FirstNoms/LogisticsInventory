package com.example.logisticsinventory.service;

import com.example.logisticsinventory.data.model.ProductQuantity;
import com.example.logisticsinventory.data.model.Product;
import com.example.logisticsinventory.data.repository.ProductQuantityRepository;
import com.example.logisticsinventory.service.dto.InventoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductQuantityServiceImpl implements ProductQuantityService {
    private final ProductQuantityRepository productQuantityRepository;

    @Override
    public ProductQuantity createInventoryItem(InventoryDto inventory) {
        ProductQuantity InventoryItem = new ProductQuantity();
        InventoryItem.setProduct(inventory.getProduct());
        InventoryItem.setQuantity(inventory.getQuantity());
        InventoryItem.setLastModifiedDate(LocalDateTime.now());
        return productQuantityRepository.save(InventoryItem);
    }

    @Override
    public ProductQuantity editInventoryItem(InventoryDto inventoryDto) {
        ProductQuantity inventoryItem = productQuantityRepository.findByProduct(inventoryDto.getProduct());
        inventoryItem.setQuantity(inventoryDto.getQuantity());
        return productQuantityRepository.save(inventoryItem);
    }

    @Override
    public void deleteInventoryItem(Product product) {
        ProductQuantity inventoryItem = productQuantityRepository.findByProduct(product);
        productQuantityRepository.delete(inventoryItem);
    }

    @Override
    public List<ProductQuantity> getAllInventoryItems() {
        return productQuantityRepository.findAll();
    }
}
