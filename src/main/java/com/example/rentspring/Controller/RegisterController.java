package com.example.rentspring.Controller;

import com.example.rentspring.entities.User;
import com.example.rentspring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping
    public String registerUser(@RequestParam String fullName, @RequestParam String city,
                               @RequestParam String country, @RequestParam String username,
                               @RequestParam String password, @RequestParam String birthDate,
                               @RequestParam String email) {
        User newUser = new User();
        newUser.setFullName(fullName);
        newUser.setCity(city);
        newUser.setCountry(country);
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setBirthDate(birthDate);
        newUser.setEmail(email);
        newUser.setRating(5);
        newUser.setBlocked(false);

        userService.saveUser(newUser);
        return "redirect:/login";
    }
}
