package pl.application.reservation.tables.restaurant.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.application.reservation.tables.restaurant.model.Restaurant;
import pl.application.reservation.tables.restaurant.services.RestaurantService;

@RestController
@RequestMapping("/admin/restaurants")
public class AdminController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/{restaurantId}/verify")
    public ResponseEntity<String> updateRestaurantStatus(@PathVariable Integer restaurantId,
                                                         @RequestParam String status) {
        try {
            restaurantService.updateRestaurantStatus(restaurantId, Restaurant.Status.valueOf(status));
            return ResponseEntity.ok("Status updated");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid status");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error status updating");
        }

}

}
