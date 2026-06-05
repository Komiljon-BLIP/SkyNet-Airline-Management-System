package com.skynet.skynet_backend.controller;

import com.skynet.skynet_backend.dsa.tree.AVLTreeService;
import com.skynet.skynet_backend.dto.FlightPriceDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights/tree")
@RequiredArgsConstructor
public class AVLController {

    private final AVLTreeService avlTreeService;

    @GetMapping("/range")
    public List<FlightPriceDTO> rangeSearch(
            @RequestParam double min,
            @RequestParam double max
    ) {

        return avlTreeService
                .findFlightsByPriceRange(
                        min,
                        max
                );
    }
}