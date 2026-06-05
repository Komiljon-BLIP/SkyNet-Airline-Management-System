package com.skynet.skynet_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SearchResultDTO {

    private String searchTerm;
    private int matchesFound;
    private long executionTimeMs;
}