package com.example.springdatajpahomework.model.dto.response;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
public class ProductResponse {
    private Long productId;
    private String productName;
    private Double unitPrice;
    private String description;

    public ProductResponse(Long productId, String productName, Double unitPrice, String description) {
        this.productId = productId;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.description = description;
    }
}
