package com.coherentsolutions.advanced.java.ajalecture20microservices.section03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * This class demonstrates inter-service communication in a microservices architecture.
 * It includes a simple RESTful service and a client that communicates with this service using RestTemplate.
 */
@SpringBootApplication
public class InterServiceCommunicationDemo {

    public static void main(String[] args) {
        SpringApplication.run(InterServiceCommunicationDemo.class, args);
    }
}

/**
 * REST controller that provides an endpoint to retrieve a greeting message.
 */
@RestController
@RequestMapping("/api")
class GreetingController {

    /**
     * Endpoint to retrieve a greeting message.
     *
     * @return A greeting message.
     */
    @GetMapping("/greeting")
    public String getGreeting() {
        return "Hello from the Greeting Service!";
    }
}

/**
 * REST controller that acts as a client to consume the Greeting Service.
 */
@RestController
@RequestMapping("/client")
class GreetingClientController {

    private final RestTemplate restTemplate;

    public GreetingClientController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Endpoint to retrieve a greeting message from the Greeting Service.
     *
     * @return The greeting message from the Greeting Service.
     */
    @GetMapping("/fetch-greeting")
    public String fetchGreeting() {
        String serviceUrl = "http://localhost:8080/api/greeting";
        return restTemplate.getForObject(serviceUrl, String.class);
    }
}

/**
 * Configuration class to create a RestTemplate bean.
 */
@Configuration
class RestTemplateConfig {

    /**
     * Creates a RestTemplate bean.
     *
     * @return A RestTemplate instance.
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
