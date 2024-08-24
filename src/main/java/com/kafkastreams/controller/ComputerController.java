package com.kafkastreams.controller;

import com.kafkastreams.data.EventPayload;
import com.kafkastreams.event.ComputerEventSender;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/computer")
@RequiredArgsConstructor
public class ComputerController {

    private final ComputerEventSender sender;

    @PostMapping
    public void sendEvent(@RequestBody EventPayload payload){
    sender.publish(payload);
    }
}
