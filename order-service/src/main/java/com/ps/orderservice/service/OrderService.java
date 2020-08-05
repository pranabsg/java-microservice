package com.ps.orderservice.service;

import com.ps.orderservice.common.Payment;
import com.ps.orderservice.common.TransactionRequest;
import com.ps.orderservice.common.TransactionResponse;
import com.ps.orderservice.entity.Order;
import com.ps.orderservice.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepo repo;

    @Autowired
    private RestTemplate restTemplate;

    public TransactionResponse saveOrder(TransactionRequest request){
        String paymentMessage = " ";
        Order order = request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setPrice(order.getPrice());

        Payment paymentResponse = restTemplate.postForObject("http://PAYMENT-SERVICE/payment/makePayment", payment, Payment.class);
        paymentMessage = paymentResponse.equals("success") ? "payment success" : "payment failure";
        repo.save(order);
        return new TransactionResponse(order, paymentResponse.getTransactionId(), paymentResponse.getPrice(), paymentMessage);
    }

}
