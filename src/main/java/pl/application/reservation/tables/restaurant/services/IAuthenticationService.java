package pl.application.reservation.tables.restaurant.services;

import jakarta.servlet.http.HttpServletRequest;

public interface IAuthenticationService {

    boolean authenticate(String loginOrEmail, String password);

    boolean authenticatePassword(String email, String password);

    void logout(HttpServletRequest request);

}
