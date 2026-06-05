package com.skynet.skynet_backend.dsa.graph;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PathResult {

    private List<String> path;
    private double totalCost;
}