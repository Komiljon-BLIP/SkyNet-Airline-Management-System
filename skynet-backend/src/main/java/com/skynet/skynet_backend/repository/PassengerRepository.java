package com.skynet.skynet_backend.repository;

import com.skynet.skynet_backend.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository
        extends JpaRepository<Passenger, Long> {
}