package com.example.springdatajpahomework.repository;

import com.example.springdatajpahomework.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("select o from Order o where o.customer.customerId = :customerId")
    List<Order> findOrdersByCustomerCustomerId(@Param("customerId") Long id);
}

