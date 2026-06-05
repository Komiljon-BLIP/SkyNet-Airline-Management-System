package com.skynet.skynet_backend.dsa.hashing;

import com.skynet.skynet_backend.dto.PassengerLookupDTO;
import com.skynet.skynet_backend.entity.Passenger;
import com.skynet.skynet_backend.repository.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class HashTableService {

    private final PassengerRepository passengerRepository;

    public PassengerLookupDTO findByPNR(String pnr) {

        long start = System.currentTimeMillis();

        Map<String, Passenger> hashTable =
                new HashMap<>();

        for (Passenger passenger :
                passengerRepository.findAll()) {

            hashTable.put(
                    passenger.getPnr(),
                    passenger
            );
        }

        Passenger passenger =
                hashTable.get(pnr);

        long end = System.currentTimeMillis();

        System.out.println(
                "Hash Lookup Time: "
                        + (end - start)
                        + " ms"
        );

        if (passenger == null) {
            return null;
        }

        return new PassengerLookupDTO(
                passenger.getId(),
                passenger.getName(),
                passenger.getPnr(),
                passenger.getStatus()
        );
    }
}