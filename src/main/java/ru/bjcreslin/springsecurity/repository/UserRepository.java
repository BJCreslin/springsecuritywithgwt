package ru.bjcreslin.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bjcreslin.springsecurity.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
