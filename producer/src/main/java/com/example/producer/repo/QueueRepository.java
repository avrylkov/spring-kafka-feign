package com.example.producer.repo;

import com.example.model.Queue;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QueueRepository extends CrudRepository<Queue, Long> {

    Queue getByActiveTrue();

    List<Queue> findQueuesByActiveTrue();

}
