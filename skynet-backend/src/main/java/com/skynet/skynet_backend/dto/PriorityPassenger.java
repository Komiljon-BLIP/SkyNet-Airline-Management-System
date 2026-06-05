package com.skynet.skynet_backend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PriorityPassenger {

    private String name;
    private String pnr;
    private String status;
}