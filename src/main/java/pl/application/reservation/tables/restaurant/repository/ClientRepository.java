package pl.application.reservation.tables.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.application.reservation.tables.restaurant.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    // Dodaj inne metody repozytorium związane z klientami, jeśli są potrzebne
}

