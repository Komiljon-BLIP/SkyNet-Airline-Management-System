package com.skynet.skynet_backend.controller;

import com.skynet.skynet_backend.dsa.hashing.HashTableService;
import com.skynet.skynet_backend.dto.PassengerLookupDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/passengers/hash")
@RequiredArgsConstructor
public class HashTableController {

    private final HashTableService hashTableService;

    @GetMapping
    public PassengerLookupDTO findPassenger(
            @RequestParam String pnr
    ) {

        return hashTableService.findByPNR(pnr);
    }
}