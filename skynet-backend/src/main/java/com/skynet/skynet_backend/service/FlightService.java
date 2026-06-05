package com.skynet.skynet_backend.service;

import com.skynet.skynet_backend.entity.Flight;
import com.skynet.skynet_backend.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;

    public Flight create(Flight flight) {
        return flightRepository.save(flight);
    }

    public List<Flight> getAll() {
        return flightRepository.findAll();
    }

    public Flight getById(Long id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found"));
    }

    public void delete(Long id) {
        flightRepository.deleteById(id);
    }
}