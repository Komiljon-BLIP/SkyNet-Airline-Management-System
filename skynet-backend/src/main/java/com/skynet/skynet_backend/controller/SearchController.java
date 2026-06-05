package com.skynet.skynet_backend.controller;

import com.skynet.skynet_backend.dsa.search.KMPService;
import com.skynet.skynet_backend.dto.SearchResultDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/search")
@RequiredArgsConstructor
public class SearchController {

    private final KMPService kmpService;

    @GetMapping
    public SearchResultDTO search(
            @RequestParam String pattern
    ) {

        return kmpService.search(pattern);
    }
}