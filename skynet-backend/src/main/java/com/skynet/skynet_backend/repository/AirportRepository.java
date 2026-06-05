package com.skynet.skynet_backend.repository;

import com.skynet.skynet_backend.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
}