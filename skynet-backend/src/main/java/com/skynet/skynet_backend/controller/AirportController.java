package com.skynet.skynet_backend.controller;



import com.skynet.skynet_backend.entity.Airport;
import com.skynet.skynet_backend.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airports")
@RequiredArgsConstructor
public class AirportController {

    private final AirportService airportService;

    @PostMapping
    public Airport create(@RequestBody Airport airport) {
        return airportService.create(airport);
    }

    @GetMapping
    public List<Airport> getAll() {
        return airportService.getAll();
    }
}