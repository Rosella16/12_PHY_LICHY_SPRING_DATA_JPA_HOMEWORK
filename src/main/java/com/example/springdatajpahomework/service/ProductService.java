package com.example.springdatajpahomework.service;

import com.example.springdatajpahomework.model.dto.request.ProductRequest;
import com.example.springdatajpahomework.model.dto.response.ProductResponse;
import com.example.springdatajpahomework.model.entity.Product;
import com.example.springdatajpahomework.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {


    ProductResponse createProduct(ProductRequest productRequest);




}
