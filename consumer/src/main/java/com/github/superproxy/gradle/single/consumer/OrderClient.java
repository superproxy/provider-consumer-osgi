package com.github.superproxy.gradle.single.consumer;

import com.github.superproxy.gradle.single.api.OrderService;

public class OrderClient {

    private OrderService orderService;

    public void setService(OrderService orderService) {
        this.orderService = orderService;
    }

    public void removeService() {
        this.orderService = null;
    }

    public void doJob() {
        while (true) {
            orderService.processOrder();
            sleep();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(1000 * 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}