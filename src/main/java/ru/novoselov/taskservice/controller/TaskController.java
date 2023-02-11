package ru.novoselov.taskservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.novoselov.taskservice.model.request.CompleteTaskRequest;
import ru.novoselov.taskservice.model.request.CreateTaskRequest;
import ru.novoselov.taskservice.model.response.CreateTaskResponse;
import ru.novoselov.taskservice.service.TaskService;

@RestController
@RequestMapping("/v1/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateTaskResponse> createTask(@RequestBody @Valid CreateTaskRequest taskRequest) {
        taskService.createTask(taskRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/complete", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity completeTask(@Valid CompleteTaskRequest completeRequest) {
        return ResponseEntity.ok().build();
    }
}
