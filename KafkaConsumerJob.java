package com.example.kafkaconsumer.consumer;

import com.example.kafkaconsumer.service.KafkaService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerJob {

    private final KafkaService kafkaService;

    public KafkaConsumerJob(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @Scheduled(fixedRate = 60000)  // Runs every minute
    public void consumeKafkaMessages() {
        kafkaService.consumeMessages();
    }
}
