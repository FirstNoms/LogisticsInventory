package com.example.logisticsinventory.service;

import com.example.logisticsinventory.data.model.ProductQuantity;
import com.example.logisticsinventory.data.model.Product;
import com.example.logisticsinventory.service.dto.InventoryDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductQuantityService {
    ProductQuantity createInventoryItem(InventoryDto inventory);
    ProductQuantity editInventoryItem(InventoryDto inventory);
    void deleteInventoryItem(Product product);
    List<ProductQuantity> getAllInventoryItems();

}
