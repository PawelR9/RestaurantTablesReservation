package pl.application.reservation.tables.restaurant.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.application.reservation.tables.restaurant.model.Restaurant;
import pl.application.reservation.tables.restaurant.repository.IRestaurantRepository;

import java.util.Optional;

@Service
public class RestaurantService {
    @Autowired
    IRestaurantRepository restaurantRepository;

    public void updateRestaurantStatus(Integer restaurantId, Restaurant.Status newStatus) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(restaurantId);

        if(restaurantOptional.isPresent()) {
            Restaurant restaurant = restaurantOptional.get();
            restaurant.setStatus(newStatus);
            restaurantRepository.save(restaurant);
        } else {
            throw new EntityNotFoundException("Restaurant with id " + restaurantId +" not found.");
        }
    }


}
