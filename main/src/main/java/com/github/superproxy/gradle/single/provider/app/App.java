package com.github.superproxy.gradle.single.provider.app;

import org.apache.felix.framework.Felix;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.launch.Framework;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {

        try {

            // 添加基础类
            Thread.currentThread().setContextClassLoader(new FileSystemClassLoader("."));

            // Initialize Apache Felix Framework
            Map<String, String> configMap = new HashMap<String, String>();
            configMap.put(Constants.FRAMEWORK_STORAGE_CLEAN, "onFirstInit");
            Framework framework = new Felix(configMap);
            framework.init();

            // Install bundles
            BundleContext context = framework.getBundleContext();
            Bundle api = context.installBundle("file:api/build/libs/api-1.0.jar");
            Bundle provider = context.installBundle("file:provider/build/libs/provider-1.0.jar");

            Bundle consumer = context.installBundle("file:client/build/libs/client-1.0.jar");
            // Start and stop framework and bundles
            framework.start();
            api.start();
            provider.start();
            consumer.start();

            Thread.sleep(1000*60);
            framework.stop();
        } catch (Exception exception) {
            System.err.println("Error while executing program: " + exception);
            exception.printStackTrace();
            System.exit(0);
        }
    }
}
