package ru.novoselov.taskservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.novoselov.taskservice.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
