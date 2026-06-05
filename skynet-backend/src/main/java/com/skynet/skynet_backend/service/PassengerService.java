package com.skynet.skynet_backend.service;

import com.skynet.skynet_backend.entity.Passenger;
import com.skynet.skynet_backend.repository.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PassengerService {

    private final PassengerRepository passengerRepository;

    public Passenger create(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public List<Passenger> getAll() {

        return passengerRepository
                .findAll(PageRequest.of(0, 100))
                .getContent();
    }

    public Passenger getById(Long id) {

        return passengerRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException(
                                "Passenger not found"
                        )
                );
    }

    public void delete(Long id) {
        passengerRepository.deleteById(id);
    }
}