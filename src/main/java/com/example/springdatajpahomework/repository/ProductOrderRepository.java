package com.example.springdatajpahomework.repository;

import com.example.springdatajpahomework.model.entity.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {


}
