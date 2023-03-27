package com.olakunle.orderservice.controller;

import com.olakunle.orderservice.dto.OrderRequest;
import com.olakunle.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder (@RequestBody OrderRequest orderRequest) {
        orderService.placeOrder(orderRequest);
        return "Order places successfully";
    }



}
