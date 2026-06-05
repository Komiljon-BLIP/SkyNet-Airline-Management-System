package com.skynet.skynet_backend.repository;



import com.skynet.skynet_backend.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}