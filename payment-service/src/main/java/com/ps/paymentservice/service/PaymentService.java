package com.ps.paymentservice.service;

import com.ps.paymentservice.entity.Payment;
import com.ps.paymentservice.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepo repo;

    public Payment makePayment(Payment payment) {
        payment.setPaymentStatus(paymentStatus());
        payment.setTransactionId(UUID.randomUUID().toString());
        return repo.save(payment);
    }

    public String paymentStatus() {
        return new Random().nextBoolean() ? "success" : "failure";
    }

}
