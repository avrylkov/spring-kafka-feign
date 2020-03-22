package com.example.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaBean {

    final private KafkaTemplate template;

    public KafkaBean(KafkaTemplate template) {
      this.template = template;
    }

    public void send(String id, String message) {
        template.setDefaultTopic("test");
        template.sendDefault(id, message);
        template.flush();
    }

}
