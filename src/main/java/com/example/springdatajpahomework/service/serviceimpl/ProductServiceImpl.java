package com.example.springdatajpahomework.service.serviceimpl;

import com.example.springdatajpahomework.model.dto.request.ProductRequest;
import com.example.springdatajpahomework.model.dto.response.ProductResponse;
import com.example.springdatajpahomework.model.entity.Product;
import com.example.springdatajpahomework.repository.ProductRepository;
import com.example.springdatajpahomework.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductResponse> findAll(int pageNo, int pageSize, String sortBy, Sort.Direction sortDirection) {
        Sort sort = Sort.by(sortDirection, sortBy);
        Pageable pageable = PageRequest.of(pageNo-1, pageSize, sort);
        List<ProductResponse> productResponsesList = new ArrayList<>();
        Page<Product> productList = productRepository.findAll(pageable);
        for (Product product : productList) {
            ProductResponse productResponse = product.toResponse();
            productResponsesList.add(productResponse);
        }
        return productResponsesList;
    }

    @Override
    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            throw new IllegalArgumentException("Product not found for ID: " + id);
        }
        return product.toResponse();
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest productRequest) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            throw new IllegalArgumentException("Product not found for ID: " + id);
        }
        product.setProductName(productRequest.getProductName());
        product.setUnitPrice(productRequest.getUnitPrice());
        product.setDescription(productRequest.getDescription());
        return productRepository.save(product).toResponse();
    }


}
