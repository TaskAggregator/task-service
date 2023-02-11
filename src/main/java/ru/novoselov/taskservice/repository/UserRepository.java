package ru.novoselov.taskservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.novoselov.taskservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
