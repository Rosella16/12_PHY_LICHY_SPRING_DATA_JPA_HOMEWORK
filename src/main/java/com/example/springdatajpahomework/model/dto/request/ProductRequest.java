package com.example.springdatajpahomework.model.dto.request;

import com.example.springdatajpahomework.model.entity.Product;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
    private String productName;
    private Double unitPrice;
    private String description;

    public Product toEntity(){
        return new Product(
                null,
                this.productName,
                this.unitPrice,
                this.description,
                null);
    }

    public Product toEntity(Long product_id) {
        return new Product(
                product_id,
                this.productName,
                this.unitPrice,
                this.description,
                null);
    }
//    public Product toEntity(Long product_id){
//        Product product = new Product();
//        product.setProduct_id(this.product_id);
//        product.setProduct_name(this.product_name);
//        product.setUnit_price(this.unit_price);
//        product.setDescription(this.description);
//    }

//    public ProductResponse toProduct(Long product_id){
//        return new ProductResponse(product_id,this.product_name,this.unit_price,this.description
//        );
    }
