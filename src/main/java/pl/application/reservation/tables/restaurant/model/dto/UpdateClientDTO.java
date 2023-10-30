package pl.application.reservation.tables.restaurant.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateClientDTO {
    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
