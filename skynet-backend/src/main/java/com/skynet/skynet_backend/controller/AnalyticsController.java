package com.skynet.skynet_backend.controller;

import com.skynet.skynet_backend.dto.AnalyticsDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    @GetMapping
    public List<AnalyticsDTO> getAnalytics() {

        return List.of(

                new AnalyticsDTO(
                        "Dijkstra",
                        "O(E log V)",
                        "Shortest Path"
                ),

                new AnalyticsDTO(
                        "AVL Tree",
                        "O(log n)",
                        "Range Search"
                ),

                new AnalyticsDTO(
                        "Hash Table",
                        "O(1)",
                        "PNR Lookup"
                ),

                new AnalyticsDTO(
                        "QuickSort",
                        "O(n log n)",
                        "Flight Sorting"
                ),

                new AnalyticsDTO(
                        "MergeSort",
                        "O(n log n)",
                        "Stable Sorting"
                ),

                new AnalyticsDTO(
                        "KMP",
                        "O(n + m)",
                        "Passenger Search"
                ),

                new AnalyticsDTO(
                        "Backtracking",
                        "Exponential",
                        "Route Recovery"
                )
        );
    }
}