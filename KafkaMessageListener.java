package com.example.kafkaconsumer.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageListener {

    @KafkaListener(topics = "test-topic", groupId = "kafka-group", containerFactory = "kafkaListenerContainerFactory")
    public void listen(ConsumerRecord<String, String> record, Acknowledgment acknowledgment) {
        System.out.println("Received message: " + record.value());
        
        // Manually acknowledge the message
        acknowledgment.acknowledge();
    }
}
