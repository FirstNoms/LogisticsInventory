package com.example.logisticsinventory.service.dto;

import com.example.logisticsinventory.data.model.Category;
import lombok.Data;

@Data
public class ProductDto {
    private String name;
    private Category category;
    private Double price;
}
