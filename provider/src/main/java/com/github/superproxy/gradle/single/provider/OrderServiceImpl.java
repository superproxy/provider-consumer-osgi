package com.github.superproxy.gradle.single.provider;

import com.github.superproxy.gradle.single.api.OrderService;

public class OrderServiceImpl implements OrderService {

    int orderId = 0;

    public void processOrder() {
        System.out.println("Order id: ORD123" + orderId++);
    }
}