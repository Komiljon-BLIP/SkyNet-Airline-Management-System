package com.skynet.skynet_backend.controller;

import com.skynet.skynet_backend.dto.DashboardStatsDTO;
import com.skynet.skynet_backend.repository.AirportRepository;
import com.skynet.skynet_backend.repository.FlightRepository;
import com.skynet.skynet_backend.repository.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final AirportRepository airportRepository;
    private final FlightRepository flightRepository;
    private final PassengerRepository passengerRepository;

    @GetMapping("/stats")
    public DashboardStatsDTO stats() {

        return new DashboardStatsDTO(
                airportRepository.count(),
                flightRepository.count(),
                passengerRepository.count(),
                11
        );
    }
}