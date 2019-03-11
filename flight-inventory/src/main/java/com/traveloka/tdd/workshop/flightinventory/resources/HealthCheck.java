package com.traveloka.tdd.workshop.flightinventory.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    @GetMapping
    public String healthy() {
        return "Healthy";
    }
}
