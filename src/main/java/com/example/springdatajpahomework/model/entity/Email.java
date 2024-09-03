package com.example.springdatajpahomework.model.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Builder
@Table(name = "email")
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, nullable = false)
    private String email;

    @OneToOne(mappedBy = "email")
//    @JsonIgnore
    @JsonBackReference
    private Customer customer;

    public Email(long id, String email) {
        this.id = id;
        this.email = email;
    }
}
