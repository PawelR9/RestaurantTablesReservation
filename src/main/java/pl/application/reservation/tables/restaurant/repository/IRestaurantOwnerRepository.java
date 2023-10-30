package pl.application.reservation.tables.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.application.reservation.tables.restaurant.model.Restaurant;

@Repository
public interface IRestaurantOwnerRepository extends JpaRepository<Restaurant, Integer> {
}