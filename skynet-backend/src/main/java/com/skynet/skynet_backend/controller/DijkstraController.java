package com.skynet.skynet_backend.controller;

import com.skynet.skynet_backend.dsa.graph.DijkstraService;
import com.skynet.skynet_backend.dsa.graph.PathResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dijkstra")
@RequiredArgsConstructor
public class DijkstraController {

    private final DijkstraService dijkstraService;

    @GetMapping
    public PathResult findShortestPath(
            @RequestParam String source,
            @RequestParam String destination
    ) {

        return dijkstraService.findShortestPath(
                source,
                destination
        );
    }
}