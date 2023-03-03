package ru.novoselov.taskservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.novoselov.taskservice.domain.EventFactory;
import ru.novoselov.taskservice.domain.EventPublishService;
import ru.novoselov.taskservice.error.exception.StatusNotFoundException;
import ru.novoselov.taskservice.error.exception.TaskNotFoundException;
import ru.novoselov.taskservice.mapper.TaskMapper;
import ru.novoselov.taskservice.model.enums.TaskStatuses;
import ru.novoselov.taskservice.model.request.CreateTaskRequest;
import ru.novoselov.taskservice.repository.StatusRepository;
import ru.novoselov.taskservice.repository.TaskRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {

    @Value("${spring.application.name}")
    private String appName;
    private final TaskRepository taskRepository;
    private final StatusRepository statusRepository;
    private final EventPublishService publishService;
    private final TaskMapper taskMapper;

    public void create(CreateTaskRequest request) {
        var status = statusRepository.findById(TaskStatuses.CREATED.getId())
                .orElseThrow(TaskNotFoundException::new);

        var task = taskRepository.save(taskMapper.toEntity(request)
                .setStatus(status)
                .setUuid(UUID.randomUUID()));

        publishService.publish(EventFactory.buildTaskCreatedEvent(task).setSource(appName));

    }

    public void complete(Long taskId) {
        var task = taskRepository.findById(taskId)
                .orElseThrow(TaskNotFoundException::new);
        var status = statusRepository.findById(TaskStatuses.COMPLETED.getId())
                .orElseThrow(StatusNotFoundException::new);

        taskRepository.save(task
                .setStatus(status));

        publishService.publish(EventFactory.buildTaskCompletedEvent(task).setSource(appName));
    }
}
