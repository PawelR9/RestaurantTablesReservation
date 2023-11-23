package pl.application.reservation.tables.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.application.reservation.tables.restaurant.model.Restaurant;
import pl.application.reservation.tables.restaurant.model.User;

import java.util.Optional;

@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant, Integer> {
    @Override
    Optional<Restaurant> findById(Integer id);
    Optional<Restaurant> findByRestaurantName (String restaurantName);
}

