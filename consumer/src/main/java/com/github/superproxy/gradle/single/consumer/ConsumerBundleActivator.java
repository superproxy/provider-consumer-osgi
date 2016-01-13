package com.github.superproxy.gradle.single.consumer;

import com.github.superproxy.gradle.single.api.OrderService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class ConsumerBundleActivator implements BundleActivator {

    private ServiceTracker orderTracker;
    private OrderClient orderClient;


    public void start(BundleContext context) throws Exception {
        System.out.println("ConsumerBundleActivator Bundle start");
        orderTracker =
                new ServiceTracker(context, OrderService.class.getName(), null);
        orderTracker.open();
        OrderService orderService = (OrderService) orderTracker.getService();
        if (orderService == null) {
            System.out.println("Order service not available");
            return;
        }

        orderClient = new OrderClient();
        orderClient.setService(orderService);

        //  osgi do not block
        orderClient.doJob();
    }

    public void stop(BundleContext context) {
        System.out.println("ConsumerBundleActivator Bundle stopped");
        orderTracker.close();
    }

}