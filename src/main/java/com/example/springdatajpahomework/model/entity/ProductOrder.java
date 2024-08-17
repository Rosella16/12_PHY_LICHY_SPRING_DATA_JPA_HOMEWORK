package com.example.springdatajpahomework.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrder {
   @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

   @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn (name = "product_id")
    @JsonBackReference
    private Product product;

   @ManyToOne(optional = false, cascade = CascadeType.ALL)
   @JoinColumn (name = "order_id")
   @JsonBackReference
   private Order order;

   @Column
    private Integer quantity;

}
