package com.example.springdatajpahomework.model.dto.response;

import com.example.springdatajpahomework.model.entity.Customer;
import com.example.springdatajpahomework.model.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class OrderResponse {
    private Long orderId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime orderDate;
    private Double totalAmount;
    private Enum<OrderStatus> orderStatus = OrderStatus.PENDING;
    private List<ProductResponse> products;

    public OrderResponse(Long orderId, Double totalAmount, Customer customer, LocalDateTime orderDate, OrderStatus status, List<ProductResponse> list) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.orderStatus = status;
        this.products = list;
    }
}
