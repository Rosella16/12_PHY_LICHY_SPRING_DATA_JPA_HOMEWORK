package com.example.springdatajpahomework.service;

import com.example.springdatajpahomework.model.dto.request.OrderRequest;
import com.example.springdatajpahomework.model.dto.response.OrderResponse;
import com.example.springdatajpahomework.model.enums.OrderStatus;

import java.util.List;


public interface OrderService {
     OrderResponse createOrder(Long customerId, List<OrderRequest> orderRequest);

    OrderResponse updateOrder(Long orderId, Long customerId, OrderStatus orderStatus);

    OrderResponse getByOrderId(Long id);

    List<OrderResponse> getAllOrdersByCustomerId(Long customerId);
}
