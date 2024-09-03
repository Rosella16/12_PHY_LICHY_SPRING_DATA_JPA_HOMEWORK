package com.example.springdatajpahomework.model.dto.response;

import com.example.springdatajpahomework.model.entity.Email;
import com.example.springdatajpahomework.model.entity.Order;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Builder
public class CustomerResponse {
    private long customerId;
    private String customerName;
    private String address;
    private String phoneNumber;
    private Email email;

}

