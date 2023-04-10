package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Payment;
import com.example.demo.repository.PaymentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class PaymentService {
    
    @Autowired
    private PaymentRepository paymentRepository;
    public List<Payment> listAllpayments() {
        return paymentRepository.findAll();
    }
    public void savePayment(Payment payment){
        paymentRepository.save(payment);
    }
    public Payment getPayment(Integer payment_id){
        return paymentRepository.findById(payment_id).get();
    }

    public void deletePayment(Integer payment_id){
        paymentRepository.deleteById(payment_id);
    }
}
