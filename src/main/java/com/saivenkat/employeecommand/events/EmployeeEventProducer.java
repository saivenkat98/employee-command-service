package com.saivenkat.employeecommand.events;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

@Service
public class EmployeeEventProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final String topic;

    public EmployeeEventProducer(KafkaTemplate<String, Object> kafkaTemplate,
                                @Value("${app.kafka.topic}") String topic)
                                {
                                    this.kafkaTemplate = kafkaTemplate;;
                                    this.topic = topic;
                                }
    
    public void publishEmployeeCreated(String key, EmployeeCreatedEvent event) {
        kafkaTemplate.send(topic, key, event);
    }      
}
