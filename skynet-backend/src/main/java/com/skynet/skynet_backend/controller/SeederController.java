package com.skynet.skynet_backend.controller;

import com.skynet.skynet_backend.service.DataGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/seed")
@RequiredArgsConstructor
public class SeederController {

    private final DataGeneratorService dataGeneratorService;

    @PostMapping
    public String seed() {

        return dataGeneratorService.generateData();
    }
}