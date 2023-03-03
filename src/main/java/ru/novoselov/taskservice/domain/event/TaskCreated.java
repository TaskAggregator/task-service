package ru.novoselov.taskservice.domain.event;

import lombok.Builder;
import ru.novoselov.taskservice.config.KafkaTopics;
import ru.novoselov.taskservice.entity.Task;

@Builder
public class TaskCreated extends Event {
    private Task task;

    public TaskCreated(Task task) {
        super(KafkaTopics.TASK_CREATED.getName());
        this.task = task;
    }
}
