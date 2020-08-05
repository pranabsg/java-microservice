package com.ps.orderservice.controller;

import com.ps.orderservice.common.TransactionRequest;
import com.ps.orderservice.common.TransactionResponse;
import com.ps.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/placeOrders")
    public TransactionResponse placeOrder(@RequestBody TransactionRequest request) {
        return service.saveOrder(request);

    }

}
