package ru.novoselov.taskservice.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import ru.novoselov.taskservice.entity.User;

@Data
public class CreateTaskRequest {
    @NotNull
    private String name;
    @NotNull
    private User creator;
    private User executor;
    private String description;
}
