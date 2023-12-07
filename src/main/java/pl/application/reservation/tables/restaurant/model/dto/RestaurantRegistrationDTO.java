package pl.application.reservation.tables.restaurant.model.dto;

import lombok.Getter;
import lombok.Setter;
import pl.application.reservation.tables.restaurant.model.Restaurant;
import pl.application.reservation.tables.restaurant.model.User;

@Getter
@Setter
public class RestaurantRegistrationDTO {
    private String login;
    private String firstName;
    private String lastName;
    private String restaurantName;
    private String address;
    private String email;
    private String phoneNumber;
    private String password;
    private User.Role role = User.Role.RESTAURANT_OWNER;
    private Restaurant.Status status = Restaurant.Status.PENDING;
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
