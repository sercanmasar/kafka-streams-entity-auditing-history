package com.kafkastreams.service;

import com.kafkastreams.data.EventPayload;
import com.kafkastreams.data.entity.Computer;
import com.kafkastreams.data.repository.ComputerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class ComputerService {

    private final ComputerRepository computerRepository;

    @Transactional
    public void save(EventPayload eventPayload) {
            Computer computer = Computer.builder()
                    .id(eventPayload.getId())
                    .make(eventPayload.getMake())
                    .model(eventPayload.getModel())
                    .name(eventPayload.getName())
                    .ram(eventPayload.getRam())
                    .build();
            computerRepository.save(computer);
    }
}
