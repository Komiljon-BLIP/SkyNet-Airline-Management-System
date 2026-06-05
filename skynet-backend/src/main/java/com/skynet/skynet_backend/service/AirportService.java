package com.skynet.skynet_backend.service;



import com.skynet.skynet_backend.entity.Airport;
import com.skynet.skynet_backend.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportService {

    private final AirportRepository airportRepository;

    public Airport create(Airport airport) {
        return airportRepository.save(airport);
    }

    public List<Airport> getAll() {
        return airportRepository.findAll();
    }
}