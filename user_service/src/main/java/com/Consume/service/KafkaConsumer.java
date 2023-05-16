package com.Consume.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

     @KafkaListener(topics = "<kafka-topic>")
     public void receiveMessage(YourMessageClass message) {
          // Process the received message
     }
}

