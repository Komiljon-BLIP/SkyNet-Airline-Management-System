package com.skynet.skynet_backend.dsa.stack;


import com.skynet.skynet_backend.dto.CargoItem;
import com.skynet.skynet_backend.entity.Passenger;
import com.skynet.skynet_backend.repository.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CargoStackService {

    private final PassengerRepository passengerRepository;

    public List<CargoItem> getCargoStack() {

        long start = System.currentTimeMillis();

        Stack<Passenger> stack = new Stack<>();

        stack.addAll(passengerRepository.findAll());

        List<CargoItem> result =
                stack.stream()
                        .sorted((a, b) -> Long.compare(
                                b.getId(),
                                a.getId()
                        ))
                        .map(
                                p -> new CargoItem(
                                        p.getName(),
                                        p.getPnr()
                                )
                        )
                        .collect(Collectors.toList());

        long end = System.currentTimeMillis();

        System.out.println(
                "Stack Execution Time: "
                        + (end - start)
                        + " ms"
        );

        return result;
    }
}