package pl.application.reservation.tables.restaurant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/restaurantRegistrationForm")
public class RestaurantRegistrationController {

    @GetMapping
    public String showRestaurantRegistrationForm() {
        return "restaurantRegistrationForm";
    }
}
