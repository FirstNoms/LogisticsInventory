package com.example.logisticsinventory.service;

import com.example.logisticsinventory.data.model.Product;
import com.example.logisticsinventory.data.repository.InventoryRepository;
import com.example.logisticsinventory.data.repository.ProductRepository;
import com.example.logisticsinventory.service.dto.InventoryDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class InventoryServiceImplTest {

    @Autowired
    InventoryService inventoryService;

    @Autowired
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void createInventoryItem() {
        //create an Inventory item, inventory Item requires creating a product and setting its attributes.
        Product firstProduct = new Product();
        firstProduct.setName("Java");
        firstProduct.setPrice(500.0);
       productRepository.save(firstProduct);
       InventoryDto inventoryDto = new InventoryDto();
       inventoryDto.setQuantity(500L);
       inventoryDto.setProduct(firstProduct);
       inventoryService.createInventoryItem(inventoryDto);

    }

    @Test
    void editInventoryItem() {
    }

    @Test
    void deleteInventoryItem() {
    }

    @Test
    void getAllInventory() {
    }
}