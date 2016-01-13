package com.github.superproxy.gradle.single.provider;

import com.github.superproxy.gradle.single.api.OrderService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ProviderBundleActivator implements BundleActivator {

    private ServiceRegistration registration;
    private OrderService orderService = new OrderServiceImpl();

    public void start(BundleContext context) {
        registration =
                context.registerService(OrderService.class.getName(), orderService, null);
        System.out.println("ProviderBundleActivator registered");
    }

    public void stop(BundleContext context) {
        System.out.println("ProviderBundleActivator stopped");
    }

}