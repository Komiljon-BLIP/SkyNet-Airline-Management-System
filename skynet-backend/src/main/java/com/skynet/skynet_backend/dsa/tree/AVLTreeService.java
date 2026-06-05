package com.skynet.skynet_backend.dsa.tree;

import com.skynet.skynet_backend.dto.FlightPriceDTO;
import com.skynet.skynet_backend.entity.Flight;
import com.skynet.skynet_backend.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AVLTreeService {

    private final FlightRepository flightRepository;

    private AVLNode root;

    // ==========================================
    // HEIGHT
    // ==========================================

    private int height(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    // ==========================================
    // BALANCE FACTOR
    // ==========================================

    private int balanceFactor(AVLNode node) {

        if (node == null) {
            return 0;
        }

        return height(node.left) - height(node.right);
    }

    // ==========================================
    // RIGHT ROTATION
    // ==========================================

    private AVLNode rotateRight(AVLNode y) {

        AVLNode x = y.left;

        if (x == null) {
            return y;
        }

        AVLNode t2 = x.right;

        x.right = y;
        y.left = t2;

        y.height =
                Math.max(
                        height(y.left),
                        height(y.right)
                ) + 1;

        x.height =
                Math.max(
                        height(x.left),
                        height(x.right)
                ) + 1;

        return x;
    }

    // ==========================================
    // LEFT ROTATION
    // ==========================================

    private AVLNode rotateLeft(AVLNode x) {

        AVLNode y = x.right;

        if (y == null) {
            return x;
        }

        AVLNode t2 = y.left;

        y.left = x;
        x.right = t2;

        x.height =
                Math.max(
                        height(x.left),
                        height(x.right)
                ) + 1;

        y.height =
                Math.max(
                        height(y.left),
                        height(y.right)
                ) + 1;

        return y;
    }

    // ==========================================
    // INSERT
    // ==========================================

    private AVLNode insert(
            AVLNode node,
            Flight flight
    ) {

        if (node == null) {
            return new AVLNode(flight);
        }

        if (flight.getCost() < node.flight.getCost()) {

            node.left =
                    insert(
                            node.left,
                            flight
                    );

        } else {

            node.right =
                    insert(
                            node.right,
                            flight
                    );
        }

        node.height =
                1 + Math.max(
                        height(node.left),
                        height(node.right)
                );

        int balance = balanceFactor(node);

        // ==========================================
        // LL CASE
        // ==========================================

        if (balance > 1
                && node.left != null
                && flight.getCost() < node.left.flight.getCost()) {

            return rotateRight(node);
        }

        // ==========================================
        // RR CASE
        // ==========================================

        if (balance < -1
                && node.right != null
                && flight.getCost() > node.right.flight.getCost()) {

            return rotateLeft(node);
        }

        // ==========================================
        // LR CASE
        // ==========================================

        if (balance > 1
                && node.left != null
                && flight.getCost() > node.left.flight.getCost()) {

            node.left = rotateLeft(node.left);

            return rotateRight(node);
        }

        // ==========================================
        // RL CASE
        // ==========================================

        if (balance < -1
                && node.right != null
                && flight.getCost() < node.right.flight.getCost()) {

            node.right = rotateRight(node.right);

            return rotateLeft(node);
        }

        return node;
    }

    // ==========================================
    // BUILD TREE
    // ==========================================

    private void buildTree() {

        root = null;

        List<Flight> flights =
                flightRepository.findAll();

        for (Flight flight : flights) {

            root = insert(
                    root,
                    flight
            );
        }
    }

    // ==========================================
    // RANGE SEARCH
    // ==========================================

    private void rangeSearch(
            AVLNode node,
            double min,
            double max,
            List<FlightPriceDTO> result
    ) {

        if (node == null) {
            return;
        }

        if (min < node.flight.getCost()) {

            rangeSearch(
                    node.left,
                    min,
                    max,
                    result
            );
        }

        if (node.flight.getCost() >= min
                && node.flight.getCost() <= max) {

            result.add(
                    new FlightPriceDTO(
                            node.flight.getId(),
                            node.flight.getSource(),
                            node.flight.getDestination(),
                            node.flight.getCost()
                    )
            );
        }

        if (max > node.flight.getCost()) {

            rangeSearch(
                    node.right,
                    min,
                    max,
                    result
            );
        }
    }

    // ==========================================
    // PUBLIC METHOD
    // ==========================================

    public List<FlightPriceDTO> findFlightsByPriceRange(
            double min,
            double max
    ) {

        long start = System.currentTimeMillis();

        buildTree();

        List<FlightPriceDTO> result =
                new ArrayList<>();

        rangeSearch(
                root,
                min,
                max,
                result
        );

        long end = System.currentTimeMillis();

        System.out.println(
                "AVL Tree Execution Time: "
                        + (end - start)
                        + " ms"
        );

        return result;
    }
}