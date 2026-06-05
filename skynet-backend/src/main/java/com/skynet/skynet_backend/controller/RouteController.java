package com.skynet.skynet_backend.controller;


import com.skynet.skynet_backend.dsa.graph.DijkstraService;
import com.skynet.skynet_backend.dsa.graph.PathResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/routes")
@RequiredArgsConstructor
public class RouteController {

    private final DijkstraService dijkstraService;

    @GetMapping("/shortest")
    public PathResult shortestRoute(
            @RequestParam String source,
            @RequestParam String destination
    ) {

        return dijkstraService.findShortestPath(
                source,
                destination
        );
    }
}