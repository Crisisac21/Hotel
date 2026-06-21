package com.ups.hotel.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ApiInfoController {

    @GetMapping
    public Map<String, Object> apiInfo() {
        return Map.of(
                "name", "Hotel Reservas Backend",
                "status", "running",
                "documentation", "/swagger-ui.html",
                "version", "1.0.0"
        );
    }
}
