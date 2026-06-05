package com.skynet.skynet_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AnalyticsDTO {

    private String algorithm;
    private String complexity;
    private String description;
}