package com.example.springdatajpahomework.repository;

import com.example.springdatajpahomework.model.dto.request.ProductRequest;
import com.example.springdatajpahomework.model.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long > {


    Product createProduct(ProductRequest productRequest);


}
