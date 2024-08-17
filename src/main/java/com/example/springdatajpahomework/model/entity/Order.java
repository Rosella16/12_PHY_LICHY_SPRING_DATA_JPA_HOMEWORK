package com.example.springdatajpahomework.model.entity;

import com.example.springdatajpahomework.model.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
@Entity
@Getter
@Setter
@ToString
@Builder
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long order_id;

    private BigDecimal total_amount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date order_date;


    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(mappedBy = "order")
    private List<ProductOrder> productOrders = new ArrayList<>();


}




