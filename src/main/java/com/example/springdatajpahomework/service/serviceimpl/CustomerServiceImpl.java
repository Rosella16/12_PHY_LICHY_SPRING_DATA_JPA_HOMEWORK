package com.example.springdatajpahomework.service.serviceimpl;

import com.example.springdatajpahomework.model.dto.request.CustomerRequest;
import com.example.springdatajpahomework.model.dto.response.CustomerResponse;
import com.example.springdatajpahomework.model.dto.response.OrderResponse;
import com.example.springdatajpahomework.model.dto.response.ProductResponse;
import com.example.springdatajpahomework.model.entity.Customer;
import com.example.springdatajpahomework.model.entity.Product;
import com.example.springdatajpahomework.repository.CustomerRepository;
import com.example.springdatajpahomework.repository.EmailRepository;
import com.example.springdatajpahomework.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final EmailRepository emailRepository;
    private final OrderServiceImpl orderServiceImpl;

    @Override
    public CustomerResponse createCustomer(CustomerRequest customerRequest) {
        Customer customer = customerRequest.toEntity();
        Customer saveCustomer = customerRepository.save(customer);
        return saveCustomer.toResponse();
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }


@Override
public List<CustomerResponse> findAll(int pageNo, int pageSize, String sortBy, Sort.Direction sortDirection) {
    Sort sort = Sort.by(sortDirection, sortBy);
    Pageable pageable = PageRequest.of(pageNo-1, pageSize, sort);
    List<CustomerResponse> customerResponseList = new ArrayList<>();
    Page<Customer> customerList = customerRepository.findAll(pageable);

    for (Customer customer : customerList) {
        CustomerResponse customerResponse = customer.toResponse();
        customerResponseList.add(customerResponse);
        }
     return customerResponseList;
    }


    @Override
    public CustomerResponse getById(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow().toResponse();
    }

    @Override
    public CustomerResponse updateCustomer(Long id, CustomerRequest customerRequest) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        return customerRepository.save(customerRequest.toEntity(customer)).toResponse();
    }


}
