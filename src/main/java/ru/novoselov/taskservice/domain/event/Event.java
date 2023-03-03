package ru.novoselov.taskservice.domain.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
public abstract class Event {
    private final String topic;
    @Setter
    protected String source;
    private final LocalDateTime dispatchTime = LocalDateTime.now();
    private final UUID publicId = UUID.randomUUID();

}
