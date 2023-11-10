package pl.application.reservation.tables.restaurant.services;

import pl.application.reservation.tables.restaurant.exceptions.UserWithThisEmailAlreadyExistException;
import pl.application.reservation.tables.restaurant.exceptions.UserWithThisLoginAlreadyExistException;
import pl.application.reservation.tables.restaurant.model.dto.ChangeEmailDTO;
import pl.application.reservation.tables.restaurant.model.dto.ChangePasswordDTO;
import pl.application.reservation.tables.restaurant.model.dto.ClientRegistrationDTO;
import pl.application.reservation.tables.restaurant.model.dto.UpdateClientDTO;

import java.time.LocalDateTime;

public interface IUserService {


    public void registerClient(ClientRegistrationDTO clientRegistrationDTO) throws UserWithThisEmailAlreadyExistException, UserWithThisLoginAlreadyExistException;
    public boolean updateUserData(int userId, UpdateClientDTO updateClientDTO) throws UserWithThisLoginAlreadyExistException;
    public void changeEmail(int userId, ChangeEmailDTO changeEmailDTO) throws UserWithThisEmailAlreadyExistException;
    public void changePassword(int userId, ChangePasswordDTO changePasswordDTO);
}
