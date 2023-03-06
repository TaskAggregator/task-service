package ru.novoselov.taskservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.novoselov.taskservice.model.request.CreateTaskRequest;
import ru.novoselov.taskservice.model.response.CreateTaskResponse;
import ru.novoselov.taskservice.service.TaskService;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateTaskResponse> createTask(@RequestBody @Valid CreateTaskRequest taskRequest) {
        taskService.create(taskRequest);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(value = "/{id}/complete")
    public ResponseEntity<Void> completeTask(@PathVariable("id") @Valid Long taskId) {
        taskService.complete(taskId);
        return ResponseEntity.ok().build();
    }
}
