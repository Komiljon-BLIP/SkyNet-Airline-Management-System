package com.skynet.skynet_backend.controller;

import com.skynet.skynet_backend.dsa.backtracking.RouteBacktrackingService;
import com.skynet.skynet_backend.dto.RouteResultDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/routes/backtracking")
@RequiredArgsConstructor
public class BacktrackingController {

    private final RouteBacktrackingService routeBacktrackingService;

    @GetMapping
    public RouteResultDTO findRoute(
            @RequestParam String source,
            @RequestParam String destination
    ) {

        return routeBacktrackingService.findRoute(
                source,
                destination
        );
    }
}