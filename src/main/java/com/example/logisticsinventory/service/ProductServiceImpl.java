package com.example.logisticsinventory.service;

import com.example.logisticsinventory.data.model.Product;
import com.example.logisticsinventory.data.model.ProductQuantity;
import com.example.logisticsinventory.data.repository.ProductRepository;
import com.example.logisticsinventory.service.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
     private final ProductRepository productRepository;

    @Override
    public Product createProduct(ProductDto productDto) {
        Product firstProduct = new Product();
        firstProduct.setPrice(productDto.getPrice());
        firstProduct.setCategory(productDto.getCategory());
        return productRepository.save(firstProduct);
    }

    @Override
    public Product editProduct(Long id, ProductDto productDto) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("anything"));
            if(productDto.getPrice() != null) product.setPrice(productDto.getPrice());
            if(productDto.getName()  !=null) product.setName(productDto.getName());
            if(product.getCategory()!=null) productDto.setCategory(productDto.getCategory());
            return productRepository.save(product);

    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);

    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
}
