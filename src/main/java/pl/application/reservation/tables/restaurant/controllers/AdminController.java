package pl.application.reservation.tables.restaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.application.reservation.tables.restaurant.model.Restaurant;
import pl.application.reservation.tables.restaurant.services.RestaurantService;

import java.util.List;

@Controller
@RequestMapping("manageRestaurants")
public class AdminController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public ModelAndView getAllRestaurants(Model model) {
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        ModelAndView modelAndView = new ModelAndView("manageRestaurants");
        modelAndView.addObject("restaurants", restaurants);
        return modelAndView;
    }

    @PostMapping("/{restaurantId}/verify")
    public ResponseEntity<String> updateRestaurantStatus(@PathVariable Integer restaurantId,
                                                         @RequestParam Restaurant.Status status) {
        try {
            restaurantService.updateRestaurantStatus(restaurantId, status);
            return ResponseEntity.ok("Status updated");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid status");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error status updating");
        }
    }
}
