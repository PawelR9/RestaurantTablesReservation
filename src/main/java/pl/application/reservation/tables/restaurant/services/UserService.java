package pl.application.reservation.tables.restaurant.services;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.application.reservation.tables.restaurant.exceptions.UserWithThisEmailAlreadyExistException;
import pl.application.reservation.tables.restaurant.exceptions.UserWithThisLoginAlreadyExistException;
import pl.application.reservation.tables.restaurant.model.User;
import pl.application.reservation.tables.restaurant.model.dto.*;
import pl.application.reservation.tables.restaurant.repository.IUserRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void registerClient(ClientRegistrationDTO clientRegistrationDTO) throws UserWithThisEmailAlreadyExistException, UserWithThisLoginAlreadyExistException {

        if (userRepository.findByLogin(clientRegistrationDTO.getLogin()).isPresent()) {
            throw new UserWithThisLoginAlreadyExistException();
        }

        if (userRepository.findByEmail(clientRegistrationDTO.getEmail()).isPresent()) {
            throw new UserWithThisEmailAlreadyExistException();
        }

        User user = new User();
        user.setRole(clientRegistrationDTO.getRole());
        user.setLogin(clientRegistrationDTO.getLogin());
        user.setFirstName(clientRegistrationDTO.getFirstName());
        user.setLastName(clientRegistrationDTO.getLastName());
        user.setEmail(clientRegistrationDTO.getEmail().toLowerCase());
        user.setPhoneNumber(clientRegistrationDTO.getPhoneNumber());
        user.setPassword(DigestUtils.md5Hex(clientRegistrationDTO.getPassword()));
        user.setCreatedAt(LocalDateTime.now());

        userRepository.save(user);
    }

    @Override
    @Transactional
    public void registerRestaurant(RestaurantRegistrationDTO restaurantRegistrationDTO) throws UserWithThisEmailAlreadyExistException, UserWithThisLoginAlreadyExistException {
        if (userRepository.findByLogin(restaurantRegistrationDTO.getLogin()).isPresent()) {
            throw new UserWithThisLoginAlreadyExistException();
        }

        if (userRepository.findByEmail(restaurantRegistrationDTO.getEmail()).isPresent()) {
            throw new UserWithThisEmailAlreadyExistException();
        }

        User user = new User();
        user.setRole(restaurantRegistrationDTO.getRole());
        user.setLogin(restaurantRegistrationDTO.getLogin());
        user.setFirstName(restaurantRegistrationDTO.getFirstName());
        user.setLastName(restaurantRegistrationDTO.getLastName());
        user.setEmail(restaurantRegistrationDTO.getEmail().toLowerCase());
        user.setPhoneNumber(restaurantRegistrationDTO.getPhoneNumber());
        user.setPassword(DigestUtils.md5Hex(restaurantRegistrationDTO.getPassword()));
        user.setCreatedAt(LocalDateTime.now());

        userRepository.save(user);
    }

    @Override
    @Transactional
    public boolean updateUserData(int userId, UpdateClientDTO updateClientDTO)
            throws UserWithThisLoginAlreadyExistException {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            String newLogin = updateClientDTO.getLogin();

            if (!newLogin.equals(user.getLogin())) {
                if (userRepository.findByLogin(newLogin).isPresent()) {
                    throw new UserWithThisLoginAlreadyExistException();
                }
                user.setLogin(updateClientDTO.getLogin());
            }
            boolean dataChanged = !newLogin.equals(user.getLogin())
                    || !updateClientDTO.getFirstName().equals(user.getFirstName())
                    || !updateClientDTO.getLastName().equals(user.getLastName())
                    || !updateClientDTO.getPhoneNumber().equals(user.getPhoneNumber());

            if (dataChanged) {
                user.setFirstName(updateClientDTO.getFirstName());
                user.setLastName(updateClientDTO.getLastName());
                user.setPhoneNumber(updateClientDTO.getPhoneNumber());
                user.setUpdatedAt(LocalDateTime.now());

                userRepository.save(user);
            }
            return dataChanged;
        } return false;
    }

    @Override
    @Transactional
    public void changeEmail(int userId, ChangeEmailDTO changeEmailDTO)
            throws UserWithThisEmailAlreadyExistException {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (userRepository.findByEmail(changeEmailDTO.getEmail()).isPresent()) {
                throw new UserWithThisEmailAlreadyExistException();
            }
            user.setEmail(changeEmailDTO.getEmail());
            user.setUpdatedAt(LocalDateTime.now());
            userRepository.save(user);
        }
    }

    @Override
    @Transactional
    public void changePassword(int userId, ChangePasswordDTO changePasswordDTO) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setPassword(DigestUtils.md5Hex(changePasswordDTO.getNewPassword()));
            user.setUpdatedAt(LocalDateTime.now());
            userRepository.save(user);
        }
    }
}
