package com.example.springdatajpahomework.service.serviceimpl;

import com.example.springdatajpahomework.model.dto.request.ProductRequest;
import com.example.springdatajpahomework.model.dto.response.ProductResponse;
import com.example.springdatajpahomework.model.entity.Product;
import com.example.springdatajpahomework.repository.ProductRepository;
import com.example.springdatajpahomework.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@AllArgsConstructor

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;


    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
//        Product product = new Product();
//        product.setProduct_name(productRequest.getProduct_name());
//        product.setDescription(productRequest.getDescription());
//        product.setUnit_price(productRequest.getUnit_price());
        Product product = productRequest.toEntity();
        Product saveProduct = productRepository.save(product);
        return saveProduct.toResponse();
    }


}
