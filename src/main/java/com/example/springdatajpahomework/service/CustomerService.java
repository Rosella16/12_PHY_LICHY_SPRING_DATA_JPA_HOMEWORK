package com.example.springdatajpahomework.service;

import com.example.springdatajpahomework.model.dto.request.CustomerRequest;
import com.example.springdatajpahomework.model.dto.response.CustomerResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.util.List;

public interface CustomerService {


    CustomerResponse createCustomer(CustomerRequest customerRequest);

    void deleteById(Long id);

    List<CustomerResponse> findAll(int pageNo, int pageSize, String sortBy, Sort.Direction sortDirection);
//    Page<CustomerResponse> getAllCustomers(Pageable pageable);


    CustomerResponse getById(Long id);

    CustomerResponse updateCustomer(Long id, CustomerRequest customerRequest);
}
