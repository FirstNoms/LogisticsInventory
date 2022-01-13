package com.example.logisticsinventory.service;

import com.example.logisticsinventory.data.model.Category;
import com.example.logisticsinventory.data.model.Product;
import com.example.logisticsinventory.data.repository.CategoryRepository;
import com.example.logisticsinventory.data.repository.ProductRepository;
import com.example.logisticsinventory.service.dto.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class ProductServiceImplTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductService productService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void createProduct() {
        //Create a Product
        Product firstProduct = new Product();
        firstProduct.setName("Kettle");
        firstProduct.setPrice(800.0);
        Category category = Category
                .builder()
                .name("Kettle")
                .description("Kitchen Utensil")
                .build();
        categoryRepository.save(category);
        firstProduct.setCategory(category);
        //save the product in the database
        productRepository.save(firstProduct);
    }

    @Test
    void editProduct() {
        ///Create a Product
        Product firstProduct = new Product();
        firstProduct.setName("Kettle");
        firstProduct.setPrice(800.0);
        Category category = Category
                .builder()
                .name("Kettle")
                .description("Kitchen Utensil")
                .build();
        categoryRepository.save(category);
        firstProduct.setCategory(category);
        //save the product in the database
        productRepository.save(firstProduct);
        //editProduct
        assertNotNull(firstProduct.getId());
        assertEquals(firstProduct.getPrice(), 800.0);

        ProductDto productDto = new ProductDto();
        productDto.setPrice(1000.0);

        Product product = productService.editProduct(firstProduct.getId(), productDto);
        assertEquals(product.getPrice(), 1000.0);
    }

    @Test
    void deleteProduct() {
    }

    @Test
    void getAllProduct() {
    }
}