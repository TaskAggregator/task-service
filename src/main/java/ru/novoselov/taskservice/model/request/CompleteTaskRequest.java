package ru.novoselov.taskservice.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CompleteTaskRequest {
    @NotNull
    private Long taskId;
}
