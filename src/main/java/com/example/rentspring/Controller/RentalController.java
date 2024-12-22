package com.example.rentspring.Controller;

import com.example.rentspring.entities.Property;
import com.example.rentspring.entities.Rental;
import com.example.rentspring.entities.User;
import com.example.rentspring.service.PropertyService;
import com.example.rentspring.service.RentalService;
import com.example.rentspring.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class RentalController {

    private final RentalService rentalService;
    private final PropertyService propertyService;
    private final UserService userService;

    @Autowired
    public RentalController(PropertyService propertyService, RentalService rentalService, UserService userService) {
        this.propertyService = propertyService;
        this.rentalService = rentalService;
        this.userService = userService;
    }

    @GetMapping("/rentals/manage")
    public String manageRentals(HttpSession session, Model model) {
        // Получаем текущего пользователя из сессии
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) {
            return "redirect:/login";
        }

        List<Rental> rentals = rentalService.getRentalsByTenantId(currentUser.getUserId());
        model.addAttribute("rentals", rentals);
        return "rate-property";
    }

    @PostMapping("/rentals/update-rating")
    public String updateRentalRatings(HttpSession session,
                                      @RequestParam Integer rentalId,
                                      @RequestParam Integer tenantRating,
                                      @RequestParam Integer landlordRating) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) {
            return "redirect:/login";
        }

        rentalService.updateRatingsByRentalId(rentalId, tenantRating, landlordRating);
        return "redirect:/rentals/manage";
    }

    @PostMapping("/rent")
    public String rentProperty(@RequestParam int propertyId, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) {
            return "redirect:/login";
        }

        Property property = propertyService.getPropertyById(propertyId);

        User landlord = userService.getUserByUsername(property.getOwnerUsername());

        Rental rental = new Rental();
        rental.setPropertyId(property.getPropertyId());
        rental.setTenantId(currentUser.getUserId());
        rental.setLandlordId(landlord.getUserId());
        rental.setStartDate(new Date());
        rental.setEndDate(new Date(System.currentTimeMillis() + 30L * 24 * 60 * 60 * 1000));

        rentalService.saveRental(rental);

        return "redirect:/search";
    }

}
