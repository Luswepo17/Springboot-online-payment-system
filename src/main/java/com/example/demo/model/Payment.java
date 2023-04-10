package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int payment_id;
    private int id;
    private String payment_type;
    private double payment_amount;
    private String email;

    public Payment(){

    }

    public Payment( int payment_id, int id, String payment_type, float payment_amount, String email ){

        this.id= id;
        this.payment_id=payment_id;
        this.payment_type= payment_type;
        this.payment_amount= payment_amount;
        this.email= email;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPaymentId() {
        return payment_id;
    }

    public void setPaymentId(int payment_id) {
        this.payment_id = payment_id;
    }

    public String getPaymentType() {
        return payment_type;
    }

    public void setPaymentType(String payment_type) {
        this.payment_type = payment_type;
    }

    public Double getPaymentAmount() {
        return payment_amount;
    }

    public void setPaymentAmount(Double payment_amount) {
        this.payment_amount = payment_amount;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }

    
}
