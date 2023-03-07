package ru.novoselov.taskservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EventReceiveService {

    //TODO временно отключено чтение из-за ошибки при десериализации: java.lang.ClassNotFoundException: ru.novoselov.authservice.domain.event.UserSignup
    //@KafkaListener(id = "task_service_consumer", topics = "user_signup", autoStartup = "true")
    public void receiveUserSignupEvent(Object in) {
      log.info(in.toString());
    }
}
