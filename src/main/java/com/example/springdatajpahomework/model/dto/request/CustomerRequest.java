package com.example.springdatajpahomework.model.dto.request;

import com.example.springdatajpahomework.model.entity.Customer;
import com.example.springdatajpahomework.model.entity.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomerRequest {
    private String customerName;
    private String address;
    private String phoneNumber;
    private String email;

    public Customer toEntity() {
        Email email1 = new Email();
        email1.setEmail(this.email);
        return new Customer(
                null,
                this.customerName,
                this.address,
                this.phoneNumber,
                email1,
                null);

    }
    public Customer toEntity(Customer customer) {
        return new Customer(
                customer.getCustomerId(),
                this.customerName,
                this.address,
                this.phoneNumber,
                new Email(customer.getEmail().getId(), this.email),
                null);

    }
}
