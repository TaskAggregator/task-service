package ru.novoselov.taskservice.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TaskStatuses {
    CREATED(1L),
    IN_PROGRESS(2L),
    COMPLETED(3L);

    private final Long id;
}
