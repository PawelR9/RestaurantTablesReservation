package pl.application.reservation.tables.restaurant.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeEmailDTO {
    private String email;
    private String password;
}
