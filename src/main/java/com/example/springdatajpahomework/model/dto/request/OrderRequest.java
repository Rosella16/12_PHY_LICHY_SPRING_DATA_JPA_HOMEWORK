package com.example.springdatajpahomework.model.dto.request;

import com.example.springdatajpahomework.model.entity.Customer;
import com.example.springdatajpahomework.model.entity.ProductOrder;
import com.example.springdatajpahomework.model.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    private Long productId;
    private Integer quantity;


}
