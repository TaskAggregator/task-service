package ru.novoselov.taskservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.novoselov.taskservice.entity.TaskStatus;

@Repository
public interface StatusRepository extends JpaRepository<TaskStatus, Long> {
    boolean existsByName(String name);
}
