package com.skynet.skynet_backend.dsa.graph;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Edge {

    private String destination;
    private double cost;
}