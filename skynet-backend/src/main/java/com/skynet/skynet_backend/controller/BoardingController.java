package com.skynet.skynet_backend.controller;



import com.skynet.skynet_backend.dsa.queue.BoardingQueueService;
import com.skynet.skynet_backend.dto.BoardingPassenger;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boarding")
@RequiredArgsConstructor
public class BoardingController {

    private final BoardingQueueService boardingQueueService;

    @GetMapping
    public List<BoardingPassenger> getQueue() {

        return boardingQueueService.getBoardingQueue();
    }

    @GetMapping("/benchmark")
    public String benchmark() {

        long start = System.currentTimeMillis();

        boardingQueueService.getBoardingQueue();

        long end = System.currentTimeMillis();

        return "Execution Time: "
                + (end - start)
                + " ms";
    }
}