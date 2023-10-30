package pl.application.reservation.tables.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.application.reservation.tables.restaurant.model.User;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

    @Override
    Optional<User> findById(Integer integer);
    Optional<User> findByLogin (String login);
    Optional<User> findByEmail (String email);
}

