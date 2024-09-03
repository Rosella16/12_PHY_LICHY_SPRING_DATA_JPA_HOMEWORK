package com.example.springdatajpahomework.model.entity;


import com.example.springdatajpahomework.model.dto.response.ProductResponse;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
@Entity
@Getter
@Setter
@ToString
@Builder
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private Double unitPrice;
    private String description;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<ProductOrder> productOrders = new HashSet<>();

    public ProductResponse toResponse() {
        return new ProductResponse(productId, productName, unitPrice, description);
    }

}
