package pl.application.reservation.tables.restaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.application.reservation.tables.restaurant.model.User;
import pl.application.reservation.tables.restaurant.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService{

        private final UserRepository userRepository;

        @Autowired
        public UserService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        public User registerUser(User user) {
            // Dodaj logikę rejestracji użytkownika, np. walidację, hashowanie hasła, ustawienie roli, itp.
            // Następnie zapisz użytkownika w bazie danych
            return userRepository.save(user);
        }

        public  Optional<User> getUserByEmail(String email) {
            return userRepository.findByEmail(email);
        }

        // Dodaj inne metody serwisowe związane z użytkownikami, jeśli są potrzebne
    }
