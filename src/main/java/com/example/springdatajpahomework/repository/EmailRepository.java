package com.example.springdatajpahomework.repository;

import com.example.springdatajpahomework.model.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {

}

