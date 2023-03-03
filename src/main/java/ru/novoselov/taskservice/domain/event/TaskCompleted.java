package ru.novoselov.taskservice.domain.event;

import lombok.Builder;
import lombok.Getter;
import ru.novoselov.taskservice.config.KafkaTopics;
import ru.novoselov.taskservice.entity.Task;

@Builder
@Getter
public class TaskCompleted extends Event {

    private Task task;

    public TaskCompleted(Task task) {
        super(KafkaTopics.TASK_COMPLETED.getName());
        this.task = task;
    }

}
