package pl.application.reservation.tables.restaurant.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.application.reservation.tables.restaurant.model.Restaurant;
import pl.application.reservation.tables.restaurant.repository.IRestaurantRepository;

import java.util.List;

@Service
public class RestaurantService implements IRestaurantService {
    @Autowired
    IRestaurantRepository restaurantRepository;

    @Autowired
    EmailService emailService;

    public void updateRestaurantStatus(Integer restaurantId, Restaurant.Status newStatus) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new EntityNotFoundException("Restaurant with id " + restaurantId + " not found."));

        restaurant.setStatus(newStatus);
        restaurantRepository.save(restaurant);

        String userEmail = restaurant.getOwner().getEmail();

        if (newStatus == Restaurant.Status.APPROVED) {

            String title = "Twoja restauracja została zatwierdzona";
            String body = "Twoja restauracja o nazwie " + restaurant.getRestaurantName() + " została zatwierdzona. Od teraz będzie dostępna dla klientów serwisu.";

            emailService.sendEmail(userEmail, title, body);

        } else if (newStatus == Restaurant.Status.REJECTED) {
            String title = "Twoja restauracja została odrzucona";
            String body = "Twoja restauracja o nazwie " + restaurant.getRestaurantName() + " została odrzucona. W przypadku wątpliwości skontatkuj się z nami odpowiadając na tago maila.";

            emailService.sendEmail(userEmail, title, body);
        }
    }


    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }
}