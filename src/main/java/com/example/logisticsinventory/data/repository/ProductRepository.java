package com.example.logisticsinventory.data.repository;

import com.example.logisticsinventory.data.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product,Long> {

}
