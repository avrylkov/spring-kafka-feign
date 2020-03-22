package com.example.producer;

import com.example.model.Queue;
import com.example.producer.repo.QueueRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScheduledTask {

    private final QueueRepository queueRepository;
    private final KafkaBean kafkaBean;

    public ScheduledTask(QueueRepository queueRepository, KafkaBean kafkaBean) {
        this.queueRepository = queueRepository;
        this.kafkaBean = kafkaBean;
    }

    @Scheduled(fixedDelay = 2000)
    public void readQueue() {
        List<Queue> queues = queueRepository.findQueuesByActiveTrue();
        queues.forEach(q -> {
            System.out.println(q.toString());
            kafkaBean.send(String.valueOf(q.getId()), q.getText());
        });
    }

}
