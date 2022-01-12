package com.example.logisticsinventory.data.repository;

import com.example.logisticsinventory.data.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
