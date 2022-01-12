package com.example.logisticsinventory.service;

import com.example.logisticsinventory.data.model.ProductQuantity;
import com.example.logisticsinventory.data.model.Product;
import com.example.logisticsinventory.data.repository.ProductRepository;
import com.example.logisticsinventory.service.dto.InventoryDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class ProductQuantityServiceImplTest {

    @Autowired
    ProductQuantityService productQuantityService;

    @Autowired
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void createInventoryItem() {
        //create an Inventory item, inventory Item requires creating a product and setting its attributes.
        //Create a Product
        Product firstProduct = new Product();
        firstProduct.setName("Java");
        firstProduct.setPrice(500.0);
        //save the product in the database
       productRepository.save(firstProduct);
       //Create an Inventory
       InventoryDto inventoryDto = new InventoryDto();
       inventoryDto.setQuantity(500L);
       inventoryDto.setProduct(firstProduct);
       //Save.
       productQuantityService.createInventoryItem(inventoryDto);
       assertThat(inventoryDto.getQuantity()).isNotNull();
       assertThat(inventoryDto.getProduct()).isNotNull();
    }

    @Test
    void editInventoryItem() {
        //Create a Product
        Product firstProduct = new Product();
        firstProduct.setName("Java");
        firstProduct.setPrice(500.0);
        //save the product in the database
        productRepository.save(firstProduct);
        //Create an Inventory
        InventoryDto inventoryDto = new InventoryDto();
        inventoryDto.setQuantity(500L);
        inventoryDto.setProduct(firstProduct);
        //Save.
        productQuantityService.createInventoryItem(inventoryDto);
        //Edit Item

    }

    @Test
    void deleteInventoryItem() {
        //create the Inventory item then find one and delete one inventory item
        //creating 2 products.
        Product firstProduct = new Product();
        Product secondProduct = new Product();
        Product thirdProduct = new Product();
        firstProduct.setName("Java");
        firstProduct.setPrice(500.0);
        secondProduct.setName("Pot");
        secondProduct.setPrice(200.0);
        thirdProduct.setName("Fabric");
        thirdProduct.setPrice(300.0);
        //saving the product in the database
        productRepository.save(firstProduct);
        productRepository.save(secondProduct);
        productRepository.save(thirdProduct);
        //creating 2 inventory items and
        InventoryDto inventoryDto = new InventoryDto();
        inventoryDto.setQuantity(500L);
        inventoryDto.setProduct(firstProduct);
        InventoryDto inventoryDto2 = new InventoryDto();
        inventoryDto2.setQuantity(600L);
        inventoryDto2.setProduct(secondProduct);
        InventoryDto inventoryDto3 = new InventoryDto();
        inventoryDto3.setQuantity(600L);
        inventoryDto3.setProduct(secondProduct);
        productQuantityService.createInventoryItem(inventoryDto);
        productQuantityService.createInventoryItem(inventoryDto2);
        productQuantityService.createInventoryItem(inventoryDto3);
        //Delete one inventory Item.
        productQuantityService.deleteInventoryItem(firstProduct);
    }

    @Test
    void getAllInventory() {
        //Calling out all the Items in my Inventory and asserting the number of items present.
        //creating a product.
        Product firstProduct = new Product();
        firstProduct.setName("Java");
        firstProduct.setPrice(500.0);
        productRepository.save(firstProduct);
        //Items
        InventoryDto inventoryDto = new InventoryDto();
        inventoryDto.setQuantity(500L);
        inventoryDto.setProduct(firstProduct);
        productQuantityService.createInventoryItem(inventoryDto);
        List<ProductQuantity> inventories = productQuantityService.getAllInventoryItems();
    assertThat(inventories.size()).isEqualTo(1);
    }
}