package ru.bjcreslin.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bjcreslin.springsecurity.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
