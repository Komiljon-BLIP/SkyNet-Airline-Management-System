package com.skynet.skynet_backend.dsa.sorting;

import com.skynet.skynet_backend.dto.SortBenchmarkDTO;
import com.skynet.skynet_backend.entity.Flight;
import com.skynet.skynet_backend.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SortingService {

    private final FlightRepository flightRepository;

    // =====================================
    // QUICKSORT
    // =====================================

    public SortBenchmarkDTO quickSortBenchmark() {

        List<Flight> flights =
                new ArrayList<>(
                        flightRepository.findAll()
                );

        long start =
                System.currentTimeMillis();

        quickSort(
                flights,
                0,
                flights.size() - 1
        );

        long end =
                System.currentTimeMillis();

        return new SortBenchmarkDTO(
                "QuickSort",
                end - start,
                flights.size()
        );
    }

    private void quickSort(
            List<Flight> flights,
            int low,
            int high
    ) {

        if (low < high) {

            int pivot =
                    partition(
                            flights,
                            low,
                            high
                    );

            quickSort(
                    flights,
                    low,
                    pivot - 1
            );

            quickSort(
                    flights,
                    pivot + 1,
                    high
            );
        }
    }

    private int partition(
            List<Flight> flights,
            int low,
            int high
    ) {

        double pivot =
                flights.get(high).getCost();

        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (flights.get(j).getCost() < pivot) {

                i++;

                Flight temp =
                        flights.get(i);

                flights.set(
                        i,
                        flights.get(j)
                );

                flights.set(
                        j,
                        temp
                );
            }
        }

        Flight temp =
                flights.get(i + 1);

        flights.set(
                i + 1,
                flights.get(high)
        );

        flights.set(
                high,
                temp
        );

        return i + 1;
    }

    // =====================================
    // MERGESORT
    // =====================================

    public SortBenchmarkDTO mergeSortBenchmark() {

        List<Flight> flights =
                new ArrayList<>(
                        flightRepository.findAll()
                );

        long start =
                System.currentTimeMillis();

        mergeSort(flights);

        long end =
                System.currentTimeMillis();

        return new SortBenchmarkDTO(
                "MergeSort",
                end - start,
                flights.size()
        );
    }

    private List<Flight> mergeSort(
            List<Flight> flights
    ) {

        if (flights.size() <= 1) {
            return flights;
        }

        int mid =
                flights.size() / 2;

        List<Flight> left =
                mergeSort(
                        new ArrayList<>(
                                flights.subList(
                                        0,
                                        mid
                                )
                        )
                );

        List<Flight> right =
                mergeSort(
                        new ArrayList<>(
                                flights.subList(
                                        mid,
                                        flights.size()
                                )
                        )
                );

        return merge(
                left,
                right
        );
    }

    private List<Flight> merge(
            List<Flight> left,
            List<Flight> right
    ) {

        List<Flight> result =
                new ArrayList<>();

        int i = 0;
        int j = 0;

        while (
                i < left.size()
                        && j < right.size()
        ) {

            if (left.get(i).getCost()
                    <= right.get(j).getCost()) {

                result.add(left.get(i++));

            } else {

                result.add(right.get(j++));
            }
        }

        while (i < left.size()) {
            result.add(left.get(i++));
        }

        while (j < right.size()) {
            result.add(right.get(j++));
        }

        return result;
    }
}