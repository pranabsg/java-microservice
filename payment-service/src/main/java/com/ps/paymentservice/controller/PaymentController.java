package com.ps.paymentservice.controller;

import com.ps.paymentservice.entity.Payment;
import com.ps.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/makePayment")
    public Payment makePayment(@RequestBody Payment payment){
        return paymentService.makePayment(payment);
    }
}
