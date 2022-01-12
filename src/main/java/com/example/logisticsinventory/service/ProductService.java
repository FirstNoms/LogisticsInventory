package com.example.logisticsinventory.service;

import com.example.logisticsinventory.data.model.Product;
import com.example.logisticsinventory.data.model.ProductQuantity;
import com.example.logisticsinventory.service.dto.InventoryDto;
import com.example.logisticsinventory.service.dto.ProductDto;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductDto productDto);
    Product editProduct(Long id,ProductDto productDto);
    void deleteProduct(Long id);
    List<Product> getAllProduct();
}
