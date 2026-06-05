package com.skynet.skynet_backend.controller;

import com.skynet.skynet_backend.entity.Passenger;
import com.skynet.skynet_backend.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passengers")
@RequiredArgsConstructor
public class PassengerController {

    private final PassengerService passengerService;

    @PostMapping
    public Passenger create(
            @RequestBody Passenger passenger
    ) {

        return passengerService.create(
                passenger
        );
    }

    @GetMapping
    public List<Passenger> getAll() {

        return passengerService.getAll();
    }

    @GetMapping("/{id}")
    public Passenger getById(
            @PathVariable Long id
    ) {

        return passengerService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ) {

        passengerService.delete(id);
    }
}