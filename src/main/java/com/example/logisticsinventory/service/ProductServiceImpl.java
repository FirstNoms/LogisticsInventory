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
     ProductRepository productRepository;

    @Override
    public Product createProduct(ProductDto productDto) {
        Product firstProduct = new Product();
        firstProduct.setPrice(productDto.getPrice());
        firstProduct.setCategory(productDto.getCategory());
        return productRepository.save(firstProduct);
    }

    @Override
    public Product editProduct(Long id, ProductDto productDto) {
        Optional<Product> firstProduct  = productRepository.findById(id);
        firstProduct.ifPresent(product -> {
            product.setPrice(productDto.getPrice());
            product.setName(productDto.getName());
            product.setCategory(productDto.getCategory());
            productRepository.save(product);
        });
        return firstProduct.get();

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
