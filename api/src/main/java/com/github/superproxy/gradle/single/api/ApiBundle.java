package com.github.superproxy.gradle.single.api;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class ApiBundle implements BundleActivator {

    public  ApiBundle() {

    }

//    private ServiceRegistration registration;

    public void start(BundleContext context) {
//        registration =
//                context.registerService(ApiBundle.class.getName(), this, null);
        System.out.println("ApiBundle Service registered");
    }

    public void stop(BundleContext context) {
        System.out.println("Order Service stopped");
    }

}