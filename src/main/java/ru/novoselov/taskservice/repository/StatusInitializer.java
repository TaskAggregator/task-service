package ru.novoselov.taskservice.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import ru.novoselov.taskservice.entity.TaskStatus;
import ru.novoselov.taskservice.model.enums.TaskStatuses;

@Configuration
@RequiredArgsConstructor
public class StatusInitializer implements ApplicationListener<ApplicationStartedEvent> {

    private final StatusRepository statusRepository;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        for (var status: TaskStatuses.values()) {
            if (!statusRepository.existsByName(status.name())) {
                statusRepository.save(new TaskStatus(status.getId(), status.name()));
            }
        }

    }
}
