package com.skynet.skynet_backend.controller;

import com.skynet.skynet_backend.dsa.stack.CargoStackService;
import com.skynet.skynet_backend.dto.CargoItem;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cargo")
@RequiredArgsConstructor
public class CargoController {

    private final CargoStackService cargoStackService;

    @GetMapping
    public List<CargoItem> getCargoStack() {

        return cargoStackService.getCargoStack();
    }

    @GetMapping("/benchmark")
    public String benchmark() {

        long start = System.currentTimeMillis();

        cargoStackService.getCargoStack();

        long end = System.currentTimeMillis();

        return "Execution Time: "
                + (end - start)
                + " ms";
    }
}