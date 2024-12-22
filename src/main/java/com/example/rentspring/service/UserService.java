package com.example.rentspring.service;

import com.example.rentspring.entities.User;
import com.example.rentspring.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User validateUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void updateUserProfile(User user, String fullName, String city, String country, String email, String birthDate) {
        user.setFullName(fullName);
        user.setCity(city);
        user.setCountry(country);
        user.setEmail(email);
        user.setBirthDate(birthDate);
        userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));
    }
}

