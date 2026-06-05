package com.skynet.skynet_backend.controller;


import com.skynet.skynet_backend.dsa.heap.PassengerPriorityService;
import com.skynet.skynet_backend.dto.PriorityPassenger;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/checkin")
@RequiredArgsConstructor
public class PriorityController {

    private final PassengerPriorityService passengerPriorityService;

    @GetMapping
    public List<PriorityPassenger> getPriorityQueue() {
        return passengerPriorityService.getPriorityOrder();
    }

    @GetMapping("/benchmark")
    public String benchmark() {

        long start = System.currentTimeMillis();

        passengerPriorityService.getPriorityOrder();

        long end = System.currentTimeMillis();

        return "Execution Time: " + (end - start) + " ms";
    }
}