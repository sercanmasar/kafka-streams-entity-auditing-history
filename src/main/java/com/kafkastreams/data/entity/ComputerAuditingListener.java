package com.kafkastreams.data.entity;

import com.kafkastreams.utils.BeanUtils;

import jakarta.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
public class ComputerAuditingListener {

    @Autowired
    private BeanUtils beanUtils;

    public ComputerAuditingListener(BeanUtils beanUtils) {
        this.beanUtils = beanUtils;
    }

    public ComputerAuditingListener() {

    }

    @PreUpdate
    @Transactional(propagation = Propagation.MANDATORY)
    public void saveHistory(Computer computer){
        final EntityManager entityManager = beanUtils.getBean(EntityManager.class);
        ComputerHistory history = new ComputerHistory(UUID.randomUUID(),computer.getId(), computer.getName(), computer.getMake(), computer.getModel(),computer.getRam());
        entityManager.persist(history);
    }
}
