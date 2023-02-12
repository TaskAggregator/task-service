package ru.novoselov.taskservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        taskService.create(taskRequest);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(value = "/complete/{id}")
    public ResponseEntity<Void> completeTask(@PathVariable("id") @Valid CompleteTaskRequest completeRequest) {
        taskService.complete(completeRequest);
        return ResponseEntity.ok().build();
    }
}
