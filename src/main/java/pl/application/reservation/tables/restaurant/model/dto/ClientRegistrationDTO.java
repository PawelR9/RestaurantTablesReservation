package pl.application.reservation.tables.restaurant.model.dto;

import lombok.Getter;
import lombok.Setter;
import pl.application.reservation.tables.restaurant.model.User;

@Getter
@Setter
public class ClientRegistrationDTO {
    private String emailOrLogin;
    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private User.Role role = User.Role.CLIENT;

}

