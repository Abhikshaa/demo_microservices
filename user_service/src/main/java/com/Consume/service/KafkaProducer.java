package com.Consume.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

     private final KafkaTemplate<String, YourMessageClass> kafkaTemplate;

     public KafkaProducer(KafkaTemplate<String, YourMessageClass> kafkaTemplate) {
          this.kafkaTemplate = kafkaTemplate;
     }

     public void sendMessage(YourMessageClass message) {
          kafkaTemplate.send("<kafka-topic>", message);
     }
}

