package ru.novoselov.taskservice.domain.event;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
public abstract class Event {
    private String source;
    private LocalDateTime dispatchTime;
    private Long correlationId;
    private UUID publicId;

}
