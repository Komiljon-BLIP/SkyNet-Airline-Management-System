package com.skynet.skynet_backend.service;


import com.skynet.skynet_backend.entity.Airport;
import com.skynet.skynet_backend.entity.Flight;
import com.skynet.skynet_backend.entity.Passenger;
import com.skynet.skynet_backend.repository.AirportRepository;
import com.skynet.skynet_backend.repository.FlightRepository;
import com.skynet.skynet_backend.repository.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class DataGeneratorService {

    private final AirportRepository airportRepository;
    private final FlightRepository flightRepository;
    private final PassengerRepository passengerRepository;

    public String generateData() {

        Random random = new Random();

        airportRepository.deleteAll();
        flightRepository.deleteAll();
        passengerRepository.deleteAll();

        // AIRPORTS

        List<Airport> airports = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {

            airports.add(
                    Airport.builder()
                            .code("APT" + i)
                            .name("Airport " + i)
                            .city("City " + i)
                            .country("Country " + i)
                            .build()
            );
        }

        airportRepository.saveAll(airports);

        // FLIGHTS

        List<Flight> flights = new ArrayList<>();

        for (int i = 1; i <= 10000; i++) {

            Airport source =
                    airports.get(random.nextInt(airports.size()));

            Airport destination =
                    airports.get(random.nextInt(airports.size()));

            while (source.getCode().equals(destination.getCode())) {
                destination =
                        airports.get(random.nextInt(airports.size()));
            }

            flights.add(
                    Flight.builder()
                            .source(source.getCode())
                            .destination(destination.getCode())
                            .cost(100 + random.nextInt(900))
                            .distance(100 + random.nextInt(9000))
                            .duration(60 + random.nextInt(600))
                            .build()
            );
        }

        flightRepository.saveAll(flights);

        // PASSENGERS

        List<Passenger> passengers = new ArrayList<>();

        String[] statuses = {
                "PLATINUM",
                "GOLD",
                "ECONOMY"
        };

        for (int i = 1; i <= 100000; i++) {

            passengers.add(
                    Passenger.builder()
                            .name("Passenger " + i)
                            .pnr("PNR" + i)
                            .status(
                                    statuses[
                                            random.nextInt(
                                                    statuses.length
                                            )
                                            ]
                            )
                            .build()
            );
        }

        passengerRepository.saveAll(passengers);

        return "Generated Successfully";
    }
}