package com.example.springdatajpahomework.controller;

import com.example.springdatajpahomework.model.dto.request.ProductRequest;
import com.example.springdatajpahomework.model.dto.response.ApiResponse;
import com.example.springdatajpahomework.model.dto.response.ProductResponse;
import com.example.springdatajpahomework.model.entity.Product;
import com.example.springdatajpahomework.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vi/product")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ApiResponse<ProductResponse>> createProduct(@RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = productService.createProduct(productRequest);
        return ResponseEntity.ok(ApiResponse.<ProductResponse>builder()
                .status(HttpStatus.CREATED)
                .message("Product created successfully")
                .payload(productResponse)
                .build());
    }
    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse<ProductResponse>> deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.ok(ApiResponse.<ProductResponse>builder()
                .status(HttpStatus.OK)
                .message("Product deleted successfully")
                .payload(null)
                .build());
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductResponse>>> getAllProducts(
            @RequestParam(defaultValue = "1") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "ASC") Sort.Direction sortDirection
    ) {
        List<ProductResponse> products = productService.findAll(pageNo, pageSize, sortBy, sortDirection);
        return ResponseEntity.ok(ApiResponse.<List<ProductResponse>>builder()
                .status(HttpStatus.OK)
                .message("Successfully get all products")
                .payload(products)
                .build());
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<ProductResponse>> getProductById(@PathVariable Long id) {
        ProductResponse product = productService.getProductById(id);
        return ResponseEntity.ok(new ApiResponse<>(
                HttpStatus.OK,
                "Successfully get product by Id" + id,
                product
        ));
    }
    @PutMapping("{id}")
    public ResponseEntity<ApiResponse<ProductResponse>> updateProduct(@PathVariable Long id, @RequestBody ProductRequest productRequest) {
        ProductResponse product = productService.updateProduct(id, productRequest);
        return ResponseEntity.ok(ApiResponse.<ProductResponse>builder()
                        .status(HttpStatus.OK)
                        .message("Successfully updated product")
                        .payload(product)
                .build());
    }
}
