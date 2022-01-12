package com.example.logisticsinventory.service.dto;

import com.example.logisticsinventory.data.model.Product;
import lombok.Data;

@Data
public class InventoryDto {
    private Long quantity;
    private Product product;
}
