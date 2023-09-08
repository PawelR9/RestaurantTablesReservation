package pl.application.reservation.tables.restaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.application.reservation.tables.restaurant.model.User;
import pl.application.reservation.tables.restaurant.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerCustomer(User user) {
        if(userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Użytkownik o podanym adresie email już istnieje.");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(User.Role.CUSTOMER);
        user.setCreated_at(LocalDateTime.now());
        user.setUpdated_at(LocalDateTime.now());

        return userRepository.save(user);

    }

    public User registerRestaurantOwner(User user) {
        // Sprawdzamy, czy użytkownik o podanym adresie email już istnieje
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Użytkownik o podanym adresie email już istnieje.");
        }

        // Zakoduj hasło przed zapisem do bazy danych
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(User.Role.RESTAURANT_OWNER);
        user.setCreated_at(LocalDateTime.now());
        user.setUpdated_at(LocalDateTime.now());

        // Zapisz użytkownika w bazie danych
        return userRepository.save(user);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
