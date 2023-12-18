package pl.application.reservation.tables.restaurant.services;

import pl.application.reservation.tables.restaurant.model.Restaurant;

import java.util.List;

public interface IRestaurantService {

    void updateRestaurantStatus(Integer restaurantId, Restaurant.Status newStatus);

    List<Restaurant> getAllRestaurants();

}
