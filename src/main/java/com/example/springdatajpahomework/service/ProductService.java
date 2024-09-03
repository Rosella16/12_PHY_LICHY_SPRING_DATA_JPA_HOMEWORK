package com.example.springdatajpahomework.service;

import com.example.springdatajpahomework.model.dto.request.ProductRequest;
import com.example.springdatajpahomework.model.dto.response.ProductResponse;
import com.example.springdatajpahomework.model.entity.Product;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {


    com.example.springdatajpahomework.model.dto.response.ProductResponse createProduct(ProductRequest productRequest);


    void deleteById(Long id);

    List<ProductResponse> findAll(int pageNo, int pageSize, String sortBy, Sort.Direction sortDirection);

    ProductResponse getProductById(Long id);

    ProductResponse updateProduct(Long id, ProductRequest productRequest);
}
