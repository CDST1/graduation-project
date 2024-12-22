package com.example.rentspring.repository;

import com.example.rentspring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsernameAndPassword(String username, String password);

    Optional<User> findByUsername(String username);
}
