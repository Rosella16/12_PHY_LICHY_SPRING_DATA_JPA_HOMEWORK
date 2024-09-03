package com.example.springdatajpahomework.service.serviceimpl;

import com.example.springdatajpahomework.model.dto.request.OrderRequest;
import com.example.springdatajpahomework.model.dto.response.OrderResponse;
import com.example.springdatajpahomework.model.dto.response.ProductResponse;
import com.example.springdatajpahomework.model.entity.Customer;
import com.example.springdatajpahomework.model.entity.Order;
import com.example.springdatajpahomework.model.entity.Product;
import com.example.springdatajpahomework.model.entity.ProductOrder;
import com.example.springdatajpahomework.model.enums.OrderStatus;
import com.example.springdatajpahomework.repository.CustomerRepository;
import com.example.springdatajpahomework.repository.OrderRepository;
import com.example.springdatajpahomework.repository.ProductOrderRepository;
import com.example.springdatajpahomework.repository.ProductRepository;
import com.example.springdatajpahomework.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final ProductOrderRepository productOrderRepository;

    @Override
    public OrderResponse createOrder(Long customerId, List<OrderRequest> orderRequest) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer == null) {
            throw new IllegalArgumentException("Customer not found for ID: " + customerId);
        }
        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderDate(LocalDateTime.now());

        List<ProductOrder> productOrders = new ArrayList<>();
        List<ProductResponse> products = new ArrayList<>();
         double totalAmount = 0.00;
         for (OrderRequest request : orderRequest) {
             Product product = productRepository.findById(request.getProductId()).orElse(null);
             if (product == null) {
                 throw new IllegalArgumentException("Product not found for ID: " + request.getProductId());
             }
             Integer quantity = request.getQuantity();
             Double price = product.getUnitPrice();
             double subTotal = price * quantity;
             totalAmount += subTotal;

             products.add(product.toResponse());
             productOrders.add(new ProductOrder(product, order));
         }

            order.setProductOrders(productOrders);
            order.setTotalAmount(totalAmount);
            orderRepository.save(order);
            productOrderRepository.saveAll(productOrders);

        return order.toResponse(products);
    }

    @Override
    public OrderResponse updateOrder(Long orderId, Long customerId, OrderStatus orderStatus) {
        Order order = orderRepository.findById(orderId).orElse(null);
        Customer customer = customerRepository.findById(customerId).orElse(null);

        if (order == null || customer == null) {
            throw new IllegalArgumentException("Order or Customer not found");
        }

        order.setCustomer(customer);
        order.setStatus(orderStatus);
        return orderRepository.save(order).toResponse();
    }

    @Override
    public OrderResponse getByOrderId(Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order == null) {
            throw new IllegalArgumentException("Order not found for ID: " + id);
        }
        return order.toResponse();
    }

    @Override
    public List<OrderResponse> getAllOrdersByCustomerId(Long customerId) {
        List<Order> orders = orderRepository.findOrdersByCustomerCustomerId(customerId);
        if (orders.isEmpty()) {
            throw new IllegalArgumentException("No orders found for customer ID: " + customerId);
        }
        return orders.stream().map(Order::toResponse).toList();
    }
}
