package com.kafkastreams.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(ComputerAuditingListener.class)
@Entity
@Table(name = "computer")
public class Computer {
    @Id
    private Long id;

    private String name;

    private String make;

    private Integer model;

    private Integer ram;
}
