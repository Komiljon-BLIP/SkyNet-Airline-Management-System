package com.skynet.skynet_backend.dsa.graph;

import com.skynet.skynet_backend.entity.Flight;
import com.skynet.skynet_backend.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class DijkstraService {

    private final FlightRepository flightRepository;

    public PathResult findShortestPath(
            String source,
            String destination
    ) {

        long start = System.currentTimeMillis();

        List<Flight> flights = flightRepository.findAll();

        Map<String, List<Edge>> graph = new HashMap<>();

        for (Flight flight : flights) {

            graph.computeIfAbsent(
                    flight.getSource(),
                    k -> new ArrayList<>()
            ).add(
                    new Edge(
                            flight.getDestination(),
                            flight.getCost()
                    )
            );
        }

        Map<String, Double> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();

        PriorityQueue<String> pq =
                new PriorityQueue<>(
                        Comparator.comparingDouble(distances::get)
                );

        for (String airport : graph.keySet()) {

            distances.put(
                    airport,
                    Double.MAX_VALUE
            );
        }

        distances.put(source, 0.0);

        pq.add(source);

        while (!pq.isEmpty()) {

            String current = pq.poll();

            if (current.equals(destination)) {
                break;
            }

            for (Edge edge :
                    graph.getOrDefault(
                            current,
                            Collections.emptyList()
                    )) {

                double newDistance =
                        distances.get(current)
                                + edge.getCost();

                if (newDistance <
                        distances.getOrDefault(
                                edge.getDestination(),
                                Double.MAX_VALUE
                        )) {

                    distances.put(
                            edge.getDestination(),
                            newDistance
                    );

                    previous.put(
                            edge.getDestination(),
                            current
                    );

                    pq.add(
                            edge.getDestination()
                    );
                }
            }
        }

        List<String> path = new ArrayList<>();

        String current = destination;

        while (current != null) {

            path.add(current);

            current = previous.get(current);
        }

        Collections.reverse(path);

        long end = System.currentTimeMillis();

        System.out.println(
                "Dijkstra Execution Time: "
                        + (end - start)
                        + " ms"
        );

        return new PathResult(
                path,
                distances.getOrDefault(
                        destination,
                        Double.MAX_VALUE
                )
        );
    }
}