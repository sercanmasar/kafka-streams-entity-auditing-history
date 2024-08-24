package com.kafkastreams.data;

import lombok.Data;

@Data
public class EventPayload {

    private Long id;

    private String name;

    private String make;

    private Integer model;

    private Integer ram;
}
