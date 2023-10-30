package pl.application.reservation.tables.restaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.application.reservation.tables.restaurant.model.Restaurant;
import pl.application.reservation.tables.restaurant.repository.IRestaurantOwnerRepository;

@Service
public class RestaurantOwnerService {
    private final IRestaurantOwnerRepository IRestaurantOwnerRepository;

    @Autowired
    public RestaurantOwnerService(IRestaurantOwnerRepository IRestaurantOwnerRepository) {
        this.IRestaurantOwnerRepository = IRestaurantOwnerRepository;
    }

    public Restaurant registerRestaurantOwner(Restaurant restaurantOwner) {
        // Dodać logikę rejestracji właściciela restauracji,
        // Następnie zapisać właściciela restauracji w bazie danych
        return IRestaurantOwnerRepository.save(restaurantOwner);
    }

    // Dodać inne metody serwisowe związane z właścicielami restauracji
}
