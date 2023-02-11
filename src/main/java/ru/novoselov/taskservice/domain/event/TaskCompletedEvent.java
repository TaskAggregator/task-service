package ru.novoselov.taskservice.domain.event;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class TaskCompletedEvent extends Event {
    private Long taskId;
}
