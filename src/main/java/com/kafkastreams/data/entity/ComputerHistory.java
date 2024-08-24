package com.kafkastreams.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "computer-history")
public class ComputerHistory {
    @Id
    private UUID id;

    private Long computerId;

    private String name;

    private String make;

    private Integer model;

    private Integer ram;
}
