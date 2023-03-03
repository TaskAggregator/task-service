package ru.novoselov.taskservice.domain;

import lombok.experimental.UtilityClass;
import ru.novoselov.taskservice.domain.event.TaskCompleted;
import ru.novoselov.taskservice.domain.event.TaskCreated;
import ru.novoselov.taskservice.entity.Task;

@UtilityClass
public class EventFactory {


    public TaskCreated buildTaskCreatedEvent(Task task) {
        return new TaskCreated(task);
    }

    public TaskCompleted buildTaskCompletedEvent(Task task) {
        return new TaskCompleted(task);
    }

}
