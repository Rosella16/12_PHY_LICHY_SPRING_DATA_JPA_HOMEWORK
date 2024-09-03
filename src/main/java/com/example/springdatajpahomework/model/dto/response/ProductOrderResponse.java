package com.example.springdatajpahomework.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class ProductOrderResponse {
    private long product_order_id;
    private String order_date;
    private ProductResponse product;
    private String order_status;
    public ProductOrderResponse(long product_order_id, String order_date, ProductResponse product, String order_status) {
            this.product_order_id = product_order_id;
            this.order_date = order_date;
            this.product = product;
            this.order_status = order_status;
        }
    }

