package com.example.springdatajpahomework.repository;

import com.example.springdatajpahomework.model.entity.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional

public interface CustomerRepository extends JpaRepository <Customer, Long>{

}
