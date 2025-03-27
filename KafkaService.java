package com.example.kafkaconsumer.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    public void consumeMessages() {
        System.out.println("Consuming messages from Kafka...");
    }
}
