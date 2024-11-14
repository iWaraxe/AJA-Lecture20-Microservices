package com.coherentsolutions.advanced.java.ajalecture20microservices.section01;

import java.util.HashMap;
import java.util.Map;

/**
 * Basic User Service to demonstrate microservice structure.
 */
public class Ex01UserService {
    private Map<Integer, String> users = new HashMap<>();

    // Constructor to initialize with some data
    public Ex01UserService() {
        users.put(1, "Alice");
        users.put(2, "Bob");
        users.put(3, "Charlie");
    }

    /**
     * Fetch user by ID.
     * @param userId ID of the user.
     * @return User name.
     */
    public String getUserById(int userId) {
        return users.getOrDefault(userId, "User not found");
    }

    public static void main(String[] args) {
        Ex01UserService userService = new Ex01UserService();
        System.out.println("Fetching user with ID 1: " + userService.getUserById(1));
        System.out.println("Fetching user with ID 4: " + userService.getUserById(4));
    }
}
