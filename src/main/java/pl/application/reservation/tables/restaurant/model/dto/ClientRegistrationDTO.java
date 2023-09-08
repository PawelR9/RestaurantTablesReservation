package pl.application.reservation.tables.restaurant.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientRegistrationDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}

