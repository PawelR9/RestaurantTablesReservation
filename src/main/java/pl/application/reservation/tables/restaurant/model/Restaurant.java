package pl.application.reservation.tables.restaurant.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity(name = "trestaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    private String restaurantName;
    private String address;
    private String openingTimeMonday;
    private String closingTimeMonday;
    private boolean mondayClosed;
    private String openingTimeTuesday;
    private String closingTimeTuesday;
    private boolean tuesdayClosed;
    private String openingTimeWednesday;
    private String closingTimeWednesday;
    private boolean wednesdayClosed;
    private String openingTimeThursday;
    private String closingTimeThursday;
    private boolean thursdayClosed;
    private String openingTimeFriday;
    private String closingTimeFriday;
    private boolean fridayClosed;
    private String openingTimeSaturday;
    private String closingTimeSaturday;
    private boolean saturdayClosed;
    private String openingTimeSunday;
    private String closingTimeSunday;
    private boolean sundayClosed;
}