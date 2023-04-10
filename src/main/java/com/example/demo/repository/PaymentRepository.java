package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    
    Payment findByEmailAndId(String email, Integer id);
    boolean existsByEmail(String email);
}
