package pl.application.reservation.tables.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.application.reservation.tables.restaurant.model.Client;

import java.time.LocalDateTime;

public interface IClientRepository extends JpaRepository<Client, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE tusers u INNER JOIN tclients c ON u.id = c.user_id SET u.first_name = :firstName, u.last_name = :lastName, u.phone_number = :phoneNumber, u.updated_at = :updatedAt, c.first_name = :firstName, c.last_name = :lastName, c.phone_number = :phoneNumber WHERE u.id = :userId", nativeQuery = true)
    void updateUserData(@Param("userId") int userId,
                        @Param("firstName") String firstName,
                        @Param("lastName") String lastName,
                        @Param("phoneNumber") String phoneNumber,
                        @Param("updatedAt") LocalDateTime updatedAt);

}
