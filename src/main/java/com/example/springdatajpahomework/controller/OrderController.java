package com.example.springdatajpahomework.controller;

import com.example.springdatajpahomework.model.dto.request.OrderRequest;
import com.example.springdatajpahomework.model.dto.response.ApiResponse;
import com.example.springdatajpahomework.model.dto.response.CustomerResponse;
import com.example.springdatajpahomework.model.dto.response.OrderResponse;
import com.example.springdatajpahomework.model.dto.response.ProductResponse;
import com.example.springdatajpahomework.model.enums.OrderStatus;
import com.example.springdatajpahomework.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vi/order")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @PostMapping("/{customerId}")
    public ResponseEntity<ApiResponse<OrderResponse>> createOrder(@PathVariable Long customerId, @RequestBody List<OrderRequest> orderRequest) {
        return ResponseEntity.ok(ApiResponse.<OrderResponse>builder()
                .status(HttpStatus.CREATED)
                .message("Product created successfully")
                .payload(orderService.createOrder(customerId, orderRequest))
                .build());
    }
    @PutMapping("/status")
    public ResponseEntity<ApiResponse<OrderResponse>> updateOrder(@RequestParam Long orderId, @RequestParam Long customerId, @RequestParam OrderStatus orderStatus) {
        return ResponseEntity.ok(ApiResponse.<OrderResponse>builder()
               .status(HttpStatus.OK)
               .message("Successfully updated order")
               .payload(orderService.updateOrder(orderId, customerId, orderStatus))
               .build());
    }

    @GetMapping("/getOrderById/{id}")
    public ResponseEntity<ApiResponse<OrderResponse>> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.<OrderResponse>builder()
                .status(HttpStatus.OK)
                .message("Successfully get order by id" + id)
                .payload(orderService.getByOrderId(id))
                .build());
    }

    @GetMapping("/getByCustomerId/{customerId}/orders")
    public ResponseEntity<ApiResponse<List<OrderResponse>>> getAllOrdersByCustomerId(@PathVariable Long customerId) {
        return ResponseEntity.ok(ApiResponse.<List<OrderResponse>>builder()
               .status(HttpStatus.OK)
               .message("Successfully get orders by customer id" + customerId)
               .payload(orderService.getAllOrdersByCustomerId(customerId))
               .build());
    }
}
