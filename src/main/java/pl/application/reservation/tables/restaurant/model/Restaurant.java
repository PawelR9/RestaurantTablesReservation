package pl.application.reservation.tables.restaurant.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity(name = "trestaurant_owners")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ownerId;
    private String restaurantName;
    private String address;
    @OneToOne
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User user;

}