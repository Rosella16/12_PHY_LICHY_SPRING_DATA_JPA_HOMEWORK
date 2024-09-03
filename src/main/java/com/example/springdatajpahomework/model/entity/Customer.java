package com.example.springdatajpahomework.model.entity;


import com.example.springdatajpahomework.model.dto.response.CustomerResponse;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
//@Builder
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String customerName;
    private String address;
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email_id", unique = true)
    @JsonManagedReference
    private Email email;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();


    public CustomerResponse toResponse() {
        return new CustomerResponse(customerId, customerName, address, phoneNumber, email);
    }

}
