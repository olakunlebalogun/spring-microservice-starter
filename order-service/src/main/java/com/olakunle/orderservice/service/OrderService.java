package com.olakunle.orderservice.service;

import com.olakunle.orderservice.dto.OrderRequest;

public interface OrderService {
    void placeOrder (OrderRequest orderRequest);
}
