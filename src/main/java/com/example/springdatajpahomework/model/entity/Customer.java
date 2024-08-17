package com.example.springdatajpahomework.model.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Builder
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customer_id;

    @OneToOne
    @JoinColumn(name = "email_id", unique = true)
    private Email email;

    private String customer_name;
    private String address;
    private String phone_number;
    @OneToMany(mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();
}
