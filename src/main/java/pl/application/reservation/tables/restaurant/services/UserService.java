package pl.application.reservation.tables.restaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.application.reservation.tables.restaurant.model.User;
import pl.application.reservation.tables.restaurant.repository.IUserRepository;

import java.util.Optional;

@Service
public class UserService{

    private final IUserRepository IUserRepository;

    @Autowired
    public UserService(IUserRepository IUserRepository) {
        this.IUserRepository = IUserRepository;
    }

    public User registerUser(User user) {
        // Dodaj logikę rejestracji użytkownika, np. walidację, hashowanie hasła, ustawienie roli, itp.
        // Następnie zapisz użytkownika w bazie danych
        return IUserRepository.save(user);
    }

    public Optional<User> getUserByEmail(String email) {
        return IUserRepository.findByEmail(email);
    }

//        public User loginUser () {};

}
