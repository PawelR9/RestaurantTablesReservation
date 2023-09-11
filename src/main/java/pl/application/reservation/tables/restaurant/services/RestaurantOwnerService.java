package pl.application.reservation.tables.restaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.application.reservation.tables.restaurant.model.RestaurantOwner;
import pl.application.reservation.tables.restaurant.repository.RestaurantOwnerRepository;

@Service
public class RestaurantOwnerService {
    private final RestaurantOwnerRepository restaurantOwnerRepository;

    @Autowired
    public RestaurantOwnerService(RestaurantOwnerRepository restaurantOwnerRepository) {
        this.restaurantOwnerRepository = restaurantOwnerRepository;
    }

    public RestaurantOwner registerRestaurantOwner(RestaurantOwner restaurantOwner) {
        // Dodaj logikę rejestracji właściciela restauracji, jeśli jest potrzebna
        // Następnie zapisz właściciela restauracji w bazie danych
        return restaurantOwnerRepository.save(restaurantOwner);
    }

    // Dodaj inne metody serwisowe związane z właścicielami restauracji, jeśli są potrzebne
}
