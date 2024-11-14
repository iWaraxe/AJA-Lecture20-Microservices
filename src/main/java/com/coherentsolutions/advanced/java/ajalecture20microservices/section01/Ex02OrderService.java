package com.coherentsolutions.advanced.java.ajalecture20microservices.section01;

/**
 * Simple Order Service to show inter-service communication.
 */
public class Ex02OrderService {
    private Ex01UserService userService;

    // Constructor to link UserService for demonstration
    public Ex02OrderService(Ex01UserService userService) {
        this.userService = userService;
    }

    /**
     * Simulate placing an order and retrieving the user who placed it.
     * @param userId ID of the user placing the order.
     */
    public void placeOrder(int userId) {
        String user = userService.getUserById(userId);
        System.out.println("Order placed by: " + user);
    }

    public static void main(String[] args) {
        Ex01UserService userService = new Ex01UserService();
        Ex02OrderService orderService = new Ex02OrderService(userService);

        System.out.println("Placing an order for user ID 2:");
        orderService.placeOrder(2);
    }
}
