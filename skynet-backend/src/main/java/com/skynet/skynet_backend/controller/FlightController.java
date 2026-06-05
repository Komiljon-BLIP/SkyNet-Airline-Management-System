package com.skynet.skynet_backend.controller;



import com.skynet.skynet_backend.entity.Flight;
import com.skynet.skynet_backend.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;

    @PostMapping
    public Flight create(@RequestBody Flight flight) {
        return flightService.create(flight);
    }

    @GetMapping
    public List<Flight> getAll() {
        return flightService.getAll();
    }

    @GetMapping("/{id}")
    public Flight getById(@PathVariable Long id) {
        return flightService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        flightService.delete(id);
    }
}