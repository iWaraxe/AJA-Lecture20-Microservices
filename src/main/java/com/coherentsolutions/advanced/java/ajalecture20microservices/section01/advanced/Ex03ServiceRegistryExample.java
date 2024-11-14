package com.coherentsolutions.advanced.java.ajalecture20microservices.section01.advanced;

/**
 * Placeholder for showing service registration (e.g., Eureka).
 * Here, we conceptually represent how a microservice would register itself.
 */
public class Ex03ServiceRegistryExample {

    public void registerService(String serviceName) {
        System.out.println("Registering service: " + serviceName);
        // In real implementations, this would interact with a service registry like Eureka.
    }

    public static void main(String[] args) {
        Ex03ServiceRegistryExample registry = new Ex03ServiceRegistryExample();
        registry.registerService("User Service");
        registry.registerService("Order Service");
    }
}
