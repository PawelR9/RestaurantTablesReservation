package pl.application.reservation.tables.restaurant.model.dto;

import lombok.Getter;
import lombok.Setter;
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
    private String openingHoursMondayFrom;
    private String openingHoursMondayTo;
    private boolean openingHoursMondayClosed;
    private String openingHoursTuesdayFrom;
    private String openingHoursTuesdayTo;
    private boolean openingHoursTuesdayClosed;
    private String openingHoursWednesdayFrom;
    private String openingHoursWednesdayTo;
    private boolean openingHoursWednesdayClosed;
    private String openingHoursThursdayFrom;
    private String openingHoursThursdayTo;
    private boolean openingHoursThursdayClosed;
    private String openingHoursFridayFrom;
    private String openingHoursFridayTo;
    private boolean openingHoursFridayClosed;
    private String openingHoursSaturdayFrom;
    private String openingHoursSaturdayTo;
    private boolean openingHoursSaturdayClosed;
    private String openingHoursSundayFrom;
    private String openingHoursSundayTo;
    private boolean openingHoursSundayClosed;
}
