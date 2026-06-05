package com.skynet.skynet_backend.dsa.queue;


import com.skynet.skynet_backend.dto.BoardingPassenger;
import com.skynet.skynet_backend.entity.Passenger;
import com.skynet.skynet_backend.repository.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardingQueueService {

    private final PassengerRepository passengerRepository;

    public List<BoardingPassenger> getBoardingQueue() {

        long start = System.currentTimeMillis();

        Queue<Passenger> queue = new LinkedList<>();

        queue.addAll(passengerRepository.findAll());

        List<BoardingPassenger> result =
                queue.stream()
                        .map(
                                p -> new BoardingPassenger(
                                        p.getName(),
                                        p.getPnr()
                                )
                        )
                        .collect(Collectors.toList());

        long end = System.currentTimeMillis();

        System.out.println(
                "Queue Execution Time: "
                        + (end - start)
                        + " ms"
        );

        return result;
    }
}
