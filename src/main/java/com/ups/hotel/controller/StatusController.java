package com.ups.hotel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class StatusController {

    @GetMapping("/status")
    public Map<String, Object> status() {
        return Map.of(
                "status", "UP",
                "application", "Hotel Reservas Backend",
                "timestamp", Instant.now().toString()
        );
    }
}
