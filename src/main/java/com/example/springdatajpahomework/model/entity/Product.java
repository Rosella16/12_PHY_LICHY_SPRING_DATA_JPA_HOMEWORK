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
    private long product_id;
    private String product_name;
    private BigDecimal unit_price;
    private String description;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<ProductOrder> productOrders = new HashSet<>();



}
