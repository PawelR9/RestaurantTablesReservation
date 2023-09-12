package pl.application.reservation.tables.restaurant.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.application.reservation.tables.restaurant.model.Client;

@Repository
public interface IClientRepository extends JpaRepository<Client, Integer> {
    }

