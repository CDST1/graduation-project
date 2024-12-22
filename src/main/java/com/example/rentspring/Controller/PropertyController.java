package com.example.rentspring.Controller;

import com.example.rentspring.entities.Property;
import com.example.rentspring.entities.User;
import com.example.rentspring.service.PropertyService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/property")
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/edit")
    public String showUserProperties(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        List<Property> userProperties = propertyService.getPropertiesByOwnerUsername(user.getUsername());
        model.addAttribute("properties", userProperties);
        return "editProperty";
    }

    @PostMapping("/edit")
    public String updateProperty(@ModelAttribute Property property, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        propertyService.updateProperty(property.getPropertyId(), property);

        List<Property> userProperties = propertyService.getPropertiesByOwnerUsername(user.getUsername());
        model.addAttribute("properties", userProperties);
        model.addAttribute("successMessage", "Объект недвижимости обновлен успешно!");

        return "editProperty";
    }
}
