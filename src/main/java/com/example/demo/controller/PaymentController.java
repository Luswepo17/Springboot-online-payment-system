package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Payment;
import com.example.demo.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    
    @Autowired
    PaymentService paymentService;

    @GetMapping("")
    public List<Payment> list(){
        return paymentService.listAllpayments();
    }

    @GetMapping("/{payment_id}")
    public ResponseEntity<Payment> get(@PathVariable Integer payment_id){
        try{
            Payment payment = paymentService.getPayment(payment_id);
            return new ResponseEntity<Payment>(payment, HttpStatus.OK);
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<Payment>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> add(@RequestBody Payment payment)
    {
        try{
            paymentService.savePayment(payment);
            return new ResponseEntity<>(HttpStatus.CREATED);
            }
            catch(Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }

    @PutMapping("/{payment_id}")
    public ResponseEntity<?> update(@RequestBody Payment payment, @PathVariable Integer payment_id){

        try {
            Payment existPayment = paymentService.getPayment(payment_id);
            payment.setPaymentId(payment_id);
            paymentService.savePayment(payment);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{payment_id}")
    public void delete(@PathVariable Integer payment_id)
    {
        paymentService.deletePayment(payment_id);
    }

    
}
