package com.example.dashboard.model;

public record ServiceStatus(
        String name,
        String status,
        String version,
        String uptime
) {
}
