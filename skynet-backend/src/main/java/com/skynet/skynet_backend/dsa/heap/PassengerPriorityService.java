package com.skynet.skynet_backend.dsa.heap;


import com.skynet.skynet_backend.dto.PriorityPassenger;
import com.skynet.skynet_backend.entity.Passenger;
import com.skynet.skynet_backend.repository.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PassengerPriorityService {

    private final PassengerRepository passengerRepository;

    public List<PriorityPassenger> getPriorityOrder() {

        long start = System.currentTimeMillis();

        PriorityQueue<Passenger> heap =
                new PriorityQueue<>(
                        Comparator.comparingInt(this::getPriority)
                                .reversed()
                );

        heap.addAll(passengerRepository.findAll());

        List<PriorityPassenger> result =
                heap.stream()
                        .sorted(
                                Comparator.comparingInt(this::getPriority)
                                        .reversed()
                        )
                        .map(
                                p -> new PriorityPassenger(
                                        p.getName(),
                                        p.getPnr(),
                                        p.getStatus()
                                )
                        )
                        .collect(Collectors.toList());

        long end = System.currentTimeMillis();

        System.out.println(
                "Heap Execution Time: "
                        + (end - start)
                        + " ms"
        );

        return result;
    }

    private int getPriority(Passenger passenger) {

        return switch (passenger.getStatus()) {

            case "PLATINUM" -> 3;
            case "GOLD" -> 2;
            default -> 1;
        };
    }
}