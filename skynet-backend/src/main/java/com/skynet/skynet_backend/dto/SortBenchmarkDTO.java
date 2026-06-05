package com.skynet.skynet_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SortBenchmarkDTO {

    private String algorithm;
    private long executionTimeMs;
    private int recordsProcessed;
}