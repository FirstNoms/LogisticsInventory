package com.example.logisticsinventory.data.repository;

import com.example.logisticsinventory.data.model.ProductQuantity;
import com.example.logisticsinventory.data.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductQuantityRepository extends JpaRepository<ProductQuantity, Long> {
    ProductQuantity findByProduct(Product product);
}
