package com.skynet.skynet_backend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FlightPriceDTO {

    private Long id;
    private String source;
    private String destination;
    private double cost;
}