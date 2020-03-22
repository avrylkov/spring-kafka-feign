package com.example.consumer;

import com.example.consumer.feign.StorageClient;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@EnableFeignClients
public class Application {

	public static Logger logger = LoggerFactory.getLogger(Application.class);

	private StorageClient storageClient;

	public Application(StorageClient storageClient) {
		this.storageClient = storageClient;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@KafkaListener(topics = {"test", "test2"})
	public void listen(ConsumerRecord<?, ?> cr) throws Exception {
		logger.info(cr.value().toString());

		storageClient.update(cr.key().toString(), cr.value().toString());
	}

}
