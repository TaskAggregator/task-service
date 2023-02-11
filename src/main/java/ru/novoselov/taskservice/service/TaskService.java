package ru.novoselov.taskservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.novoselov.taskservice.mapper.TaskMapper;
import ru.novoselov.taskservice.model.enums.TaskStatuses;
import ru.novoselov.taskservice.model.request.CreateTaskRequest;
import ru.novoselov.taskservice.repository.StatusRepository;
import ru.novoselov.taskservice.repository.TaskRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final StatusRepository statusRepository;

    private final TaskMapper taskMapper;

    public void createTask(CreateTaskRequest taskRequest) {
        var status = statusRepository.findById(TaskStatuses.CREATED.getId()).orElseThrow();
        taskRepository.save(taskMapper.toEntity(taskRequest)
                .setStatus(status)
                .setUuid(UUID.randomUUID()));
    }
}
