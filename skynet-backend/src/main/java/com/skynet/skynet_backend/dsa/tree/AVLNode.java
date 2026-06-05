package com.skynet.skynet_backend.dsa.tree;


import com.skynet.skynet_backend.entity.Flight;

public class AVLNode {

    Flight flight;

    AVLNode left;
    AVLNode right;

    int height;

    public AVLNode(Flight flight) {
        this.flight = flight;
        this.height = 1;
    }
}