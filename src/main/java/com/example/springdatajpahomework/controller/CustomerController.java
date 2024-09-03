package com.example.springdatajpahomework.controller;

import com.example.springdatajpahomework.model.dto.request.CustomerRequest;
import com.example.springdatajpahomework.model.dto.response.ApiResponse;
import com.example.springdatajpahomework.model.dto.response.CustomerResponse;
import com.example.springdatajpahomework.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/vi/customer")
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping
    public ResponseEntity<ApiResponse<CustomerResponse>> createCustomer(@RequestBody CustomerRequest customerRequest) {
        CustomerResponse customerResponse = customerService.createCustomer(customerRequest);
        return ResponseEntity.ok(ApiResponse.<CustomerResponse>builder()
               .status(HttpStatus.CREATED)
               .message("Customer created successfully")
               .payload(customerResponse)
               .build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse<CustomerResponse>> deleteCustomer(@PathVariable Long id) {
        customerService.deleteById(id);
        return ResponseEntity.ok(ApiResponse.<CustomerResponse>builder()
               .status(HttpStatus.OK)
               .message("Customer deleted successfully")
               .build());
    }


    @GetMapping
    public ResponseEntity<ApiResponse<List<CustomerResponse>>> getAllCustomers(
            @RequestParam(defaultValue = "1") int pageNo,
            @RequestParam(defaultValue = "5") int pageSize,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "DESC") Sort.Direction sortDirection) {

        List<CustomerResponse> customers = customerService.findAll(pageNo, pageSize, sortBy, sortDirection);
        return ResponseEntity.ok(ApiResponse.<List<CustomerResponse>>builder()
                .status(HttpStatus.OK)
                .message("Successfully get all customers")
                .payload(customers)
                .build());
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CustomerResponse>> getCustomerById(@PathVariable Long id) {
        CustomerResponse customerResponse = customerService.getById(id);
        return ResponseEntity.ok(ApiResponse.<CustomerResponse>builder()
               .status(HttpStatus.OK)
               .message("Successfully get customer by Id" + id)
               .payload(customerResponse)
               .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CustomerResponse>> updateCustomer(@PathVariable Long id, @RequestBody CustomerRequest customerRequest) {
        CustomerResponse customerResponse = customerService.updateCustomer(id, customerRequest);
        return ResponseEntity.ok(ApiResponse.<CustomerResponse>builder()
               .status(HttpStatus.OK)
               .message("Successfully updated customer")
               .payload(customerResponse)
               .build());
    }


}
