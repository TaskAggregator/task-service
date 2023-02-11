package ru.novoselov.taskservice.domain.event;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TaskCreatedEvent extends Event {
    private Long taskId;
}
