package pl.application.reservation.tables.restaurant.services;

import pl.application.reservation.tables.restaurant.exceptions.UserWithThisEmailAlreadyExistException;
import pl.application.reservation.tables.restaurant.exceptions.UserWithThisLoginAlreadyExistException;
import pl.application.reservation.tables.restaurant.model.dto.ClientRegistrationDTO;

import java.time.LocalDateTime;

public interface IClientService {


    public void registerClient(ClientRegistrationDTO clientRegistrationDTO) throws UserWithThisEmailAlreadyExistException, UserWithThisLoginAlreadyExistException;
    public void updateUserData(int userId, String login, String firstName, String lastName, String phoneNumber, LocalDateTime localDateTime);
}
