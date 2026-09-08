package com.example.dashboard.controller;

import com.example.dashboard.model.ServiceStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DashboardController {

    @GetMapping("/api/dashboard")
    public Map<String, Object> dashboard() {
        List<ServiceStatus> services = List.of(
                new ServiceStatus("Spring Boot API", "UP", "1.0.0", "12h 42m"),
                new ServiceStatus("Database", "UP", "PostgreSQL", "12h 40m"),
                new ServiceStatus("Message Queue", "UP", "RabbitMQ", "12h 38m"),
                new ServiceStatus("Frontend", "UP", "1.0.0", "12h 45m")
        );

        return Map.of(
                "application", "Spring Boot Maven Dashboard",
                "environment", "UAT",
                "version", "1.0.0",
                "overallStatus", "UP",
                "services", services
        );
    }

    @GetMapping("/api/hello")
    public Map<String, String> hello() {
        return Map.of(
                "message", "Hello from Spring Boot!",
                "status", "UP"
        );
    }
}
