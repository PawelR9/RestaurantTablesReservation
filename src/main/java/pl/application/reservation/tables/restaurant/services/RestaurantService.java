package pl.application.reservation.tables.restaurant.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.application.reservation.tables.restaurant.model.Restaurant;
import pl.application.reservation.tables.restaurant.repository.IRestaurantRepository;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    IRestaurantRepository restaurantRepository;

    public void updateRestaurantStatus(Integer restaurantId, Restaurant.Status newStatus) {
        Restaurant restaurant= restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new EntityNotFoundException("Restaurant with id " + restaurantId +" not found."));

        restaurant.setStatus(newStatus);
        restaurantRepository.save(restaurant);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

}