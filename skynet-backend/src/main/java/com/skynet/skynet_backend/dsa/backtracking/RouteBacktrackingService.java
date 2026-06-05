package com.skynet.skynet_backend.dsa.backtracking;

import com.skynet.skynet_backend.dto.RouteResultDTO;
import com.skynet.skynet_backend.entity.Flight;
import com.skynet.skynet_backend.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class RouteBacktrackingService {

    private final FlightRepository flightRepository;

    public RouteResultDTO findRoute(
            String source,
            String destination
    ) {

        Map<String, List<String>> graph =
                new HashMap<>();

        for (Flight flight :
                flightRepository.findAll()) {

            graph.computeIfAbsent(
                    flight.getSource(),
                    k -> new ArrayList<>()
            ).add(
                    flight.getDestination()
            );
        }

        List<String> path =
                new ArrayList<>();

        Set<String> visited =
                new HashSet<>();

        boolean found =
                backtrack(
                        source,
                        destination,
                        graph,
                        visited,
                        path
                );

        return new RouteResultDTO(
                path,
                found ? 1 : 0
        );
    }

    private boolean backtrack(
            String current,
            String destination,
            Map<String, List<String>> graph,
            Set<String> visited,
            List<String> path
    ) {

        visited.add(current);

        path.add(current);

        if (current.equals(destination)) {
            return true;
        }

        for (String neighbor :
                graph.getOrDefault(
                        current,
                        Collections.emptyList()
                )) {

            if (!visited.contains(neighbor)) {

                if (backtrack(
                        neighbor,
                        destination,
                        graph,
                        visited,
                        path
                )) {

                    return true;
                }
            }
        }

        path.remove(path.size() - 1);

        visited.remove(current);

        return false;
    }
}