package ru.novoselov.taskservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EventReceiveService {
    @KafkaListener(id = "task_service_consumer", topics = "user_signup", autoStartup = "true")
    public void receiveUserSignupEvent(Object in) {
      log.info(in.toString());
    }
}
