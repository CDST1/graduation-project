package com.example.rentspring.Controller;

import com.example.rentspring.entities.Property;
import com.example.rentspring.entities.User;
import com.example.rentspring.service.PropertyService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RentOutController {

    private final PropertyService propertyService;

    @Autowired
    public RentOutController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    // Страница с формой для добавления недвижимости
    @GetMapping("/rentOut")
    public String showRentOutForm() {
        return "rent-out";
    }

    // Обработка формы добавления недвижимости
    @PostMapping("/rentOut")
    public String rentOutProperty(@RequestParam String title,
                                  @RequestParam String description,
                                  @RequestParam String city,
                                  @RequestParam double price,
                                  @RequestParam int rooms,
                                  HttpSession session) {
        User user = (User) session.getAttribute("user");
        System.out.println("User from session: " + (user != null ? user.getUsername() : "null"));
        if (user == null) {

            return "redirect:/login";
        }

        Property property = new Property();
        property.setTitle(title);
        property.setDescription(description);
        property.setCity(city);
        property.setPrice(price);
        property.setRooms(rooms);
        property.setOwnerUsername(user.getUsername());

        propertyService.saveProperty(property);

        return "redirect:/home";
    }
}
