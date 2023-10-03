package pl.application.reservation.tables.restaurant.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantRegistrationDTO {
    private String ownerName;
    private String restaurantName;
    private String address;
    private String email;
    private String phone;
    private String password;
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
