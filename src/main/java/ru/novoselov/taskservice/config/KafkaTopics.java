package ru.novoselov.taskservice.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum KafkaTopics {
    TASK_CREATED("task-created"),
    TASK_COMPLETED("task-completed"),
    USER_SIGNUP("user-signup");

    private final String name;
}
