package ru.novoselov.taskservice.domain;

import org.springframework.stereotype.Service;
import ru.novoselov.taskservice.domain.event.TaskCreatedEvent;
import ru.novoselov.taskservice.entity.Task;

@Service
public class EventFactory {

    public TaskCreatedEvent buildTaskCreatedEvent(Task task) {
        return new TaskCreatedEvent(task.getId());
    }

}
