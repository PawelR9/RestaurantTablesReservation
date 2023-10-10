package pl.application.reservation.tables.restaurant.services;

import jakarta.servlet.http.HttpServletRequest;

public interface IAuthenticationService {

    void authenticate(String email, String password);
    void logout(HttpServletRequest request);

}
