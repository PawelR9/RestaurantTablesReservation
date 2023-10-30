package pl.application.reservation.tables.restaurant.services;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.application.reservation.tables.restaurant.exceptions.UserWithThisEmailAlreadyExistException;
import pl.application.reservation.tables.restaurant.exceptions.UserWithThisLoginAlreadyExistException;
import pl.application.reservation.tables.restaurant.model.User;
import pl.application.reservation.tables.restaurant.model.dto.ClientRegistrationDTO;
import pl.application.reservation.tables.restaurant.repository.IUserRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ClientService implements IClientService {

    private final IUserRepository userRepository;

    @Autowired
    public ClientService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void registerClient(ClientRegistrationDTO clientRegistrationDTO) throws  UserWithThisEmailAlreadyExistException, UserWithThisLoginAlreadyExistException {

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
    public void updateUserData(int userId, String login, String firstName, String lastName, String phoneNumber, LocalDateTime localDateTime) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setLogin(login);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPhoneNumber(phoneNumber);
            user.setUpdatedAt(LocalDateTime.now());

            userRepository.save(user);
        }
    }
}
