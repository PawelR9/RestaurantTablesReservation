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
public class RestaurantOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int owner_id;
    private String restaurant_name;
    private String address;
    @OneToOne
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User user;

}