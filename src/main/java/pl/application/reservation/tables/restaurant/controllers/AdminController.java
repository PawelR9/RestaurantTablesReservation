package pl.application.reservation.tables.restaurant.controllers;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.application.reservation.tables.restaurant.model.Restaurant;
import pl.application.reservation.tables.restaurant.model.User;
import pl.application.reservation.tables.restaurant.services.IRestaurantService;
import pl.application.reservation.tables.restaurant.session.SessionData;

import java.util.List;

@Controller
@RequestMapping("manageRestaurants")
public class AdminController {

    @Autowired
    private IRestaurantService restaurantService;

    @Resource
    SessionData sessionData;

    @GetMapping
    public ModelAndView getAllRestaurants(Model model, @RequestParam(name = "statusUpdated", required = false) boolean statusUpdated) {
        User user = sessionData.getUser();

        if (user != null && sessionData.isAdmin()) {
            List<Restaurant> restaurants = restaurantService.getAllRestaurants();
            ModelAndView modelAndView = new ModelAndView("manageRestaurants");
            modelAndView.addObject("restaurants", restaurants);
            modelAndView.addObject("statusUpdated", statusUpdated);
            return modelAndView;
        } else {
            return new ModelAndView("login").addObject("accessDeniedMessage", "Odmowa dostępu. Nie jesteś adminem.");
        }
    }

    @PostMapping("/{restaurantId}/verify")
    public String updateRestaurantStatus(@PathVariable Integer restaurantId,
                                                         @RequestParam Restaurant.Status status) {
        try {
            restaurantService.updateRestaurantStatus(restaurantId, status);
            return "redirect:/manageRestaurants?statusUpdated=true";
        } catch (Exception e) {
            return "redirect:/manageRestaurants?statusUpdated=false";
        }
    }
}