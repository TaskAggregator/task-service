package ru.novoselov.taskservice.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.novoselov.taskservice.error.exception.StatusNotFoundException;
import ru.novoselov.taskservice.error.exception.TaskNotFoundException;

@RestControllerAdvice
@Slf4j
public class TaskExceptionHandler {

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<String> handleTaskNotFoundException(Exception ex) {
        log.error("Task not found", ex);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.TEXT_PLAIN)
                .body("Task not found");
    }

    @ExceptionHandler(StatusNotFoundException.class)
    public ResponseEntity<String> handleStatusNotFoundException(Exception ex) {
        log.error("Error during change task status", ex);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.TEXT_PLAIN)
                .body("Error during change task status");
    }
}
