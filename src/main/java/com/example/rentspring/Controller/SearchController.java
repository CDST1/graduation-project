package com.example.rentspring.Controller;

import com.example.rentspring.entities.Property;
import com.example.rentspring.repository.PropertyRepository;
import com.example.rentspring.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private PropertyRepository propertyRepository;

    private final PropertyService propertyService;

    public SearchController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/search")
    public String searchProperties(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Integer rooms,
            Model model
    ) {
        List<Property> properties = propertyService.searchProperties(city, minPrice, maxPrice, rooms);
        model.addAttribute("properties", properties);
        return "search";
    }

}
