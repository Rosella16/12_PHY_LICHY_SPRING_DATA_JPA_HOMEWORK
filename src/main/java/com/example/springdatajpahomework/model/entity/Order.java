package com.example.springdatajpahomework.model.entity;

import com.example.springdatajpahomework.model.dto.response.OrderResponse;
import com.example.springdatajpahomework.model.dto.response.ProductResponse;
import com.example.springdatajpahomework.model.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
@Entity
@Getter
@Setter
@ToString
@Builder
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Double totalAmount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-mm-dd")
    private LocalDateTime orderDate;


    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.PENDING;

    @OneToMany(mappedBy = "order")
    private List<ProductOrder> productOrders = new ArrayList<>();

    public OrderResponse toResponse() {
        return new OrderResponse(
                orderId,
                totalAmount,
                customer,
                orderDate,
                status,
                productOrders.stream().map(pro -> pro.getProduct().toResponse()).toList());
    }

    public OrderResponse toResponse(List<ProductResponse> products) {
        return new OrderResponse(
                orderId,
                totalAmount,
                customer,
                orderDate,
                status,
                products);
    }
}




