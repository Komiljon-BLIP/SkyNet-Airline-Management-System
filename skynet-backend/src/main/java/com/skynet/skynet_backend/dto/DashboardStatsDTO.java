package com.skynet.skynet_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DashboardStatsDTO {

    private long airports;
    private long flights;
    private long passengers;
    private long algorithms;
}