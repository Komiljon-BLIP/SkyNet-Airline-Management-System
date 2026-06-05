package com.skynet.skynet_backend.controller;

import com.skynet.skynet_backend.dsa.sorting.SortingService;
import com.skynet.skynet_backend.dto.SortBenchmarkDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sorting")
@RequiredArgsConstructor
public class SortingController {

    private final SortingService sortingService;

    @GetMapping("/quick")
    public SortBenchmarkDTO quickSort() {

        return sortingService
                .quickSortBenchmark();
    }

    @GetMapping("/merge")
    public SortBenchmarkDTO mergeSort() {

        return sortingService
                .mergeSortBenchmark();
    }
}