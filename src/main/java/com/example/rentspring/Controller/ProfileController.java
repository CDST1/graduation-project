package com.example.rentspring.Controller;

import com.example.rentspring.entities.User;
import com.example.rentspring.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private final UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showProfilePage(HttpSession session, Model model) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) {
            return "redirect:/login";
        }
        model.addAttribute("user", currentUser);
        return "profile";
    }

    @PostMapping
    public String updateProfile(@RequestParam String fullName, @RequestParam String city,
                                @RequestParam String country, @RequestParam String email,
                                @RequestParam String birthDate, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) {
            return "redirect:/login";
        }

        userService.updateUserProfile(currentUser, fullName, city, country, email, birthDate);
        return "redirect:/profile?success=true";
    }
}
