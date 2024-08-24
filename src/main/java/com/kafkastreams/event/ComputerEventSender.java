package com.kafkastreams.event;

import com.kafkastreams.data.EventPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ComputerEventSender {

    public static final String EVENT_BINDING = "computerEventProducer-out-0";

    private final StreamBridge streamBridge;

    public void publish(EventPayload event) {
        streamBridge.send(EVENT_BINDING, event);
    }
}
