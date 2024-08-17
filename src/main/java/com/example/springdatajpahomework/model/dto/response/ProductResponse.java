package com.example.springdatajpahomework.model.dto.response;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    private long product_id;
    private String product_name;
    private BigDecimal unit_price;
    private String description;

    public ProductResponse(long product_id, String product_name, BigDecimal unit_price, String description) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.unit_price = unit_price;
        this.description = description;
    }
}
