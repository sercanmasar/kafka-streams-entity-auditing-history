package com.kafkastreams.event;

import com.kafkastreams.data.EventPayload;
import com.kafkastreams.service.ComputerService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
public class ComputerConsumer {

    private final ComputerService computerService;

    @Bean
    public Consumer<Message<EventPayload>> computerEventConsumer() {
        return message -> {
           EventPayload eventPayload= message.getPayload();
            computerService.save(eventPayload);
        };
    }
}
