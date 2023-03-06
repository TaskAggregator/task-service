package ru.novoselov.taskservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.novoselov.taskservice.domain.event.Event;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventPublishService {

    private final KafkaTemplate<String, Event> kafkaTemplate;

    public void publish(Event event) {
        kafkaTemplate.send(event.getTopic(), UUID.randomUUID().toString(), event);
    }


}

