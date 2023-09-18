package pl.application.reservation.tables.restaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.application.reservation.tables.restaurant.model.User;
import pl.application.reservation.tables.restaurant.repository.IUserRepository;

@Service
public class UserService{

    private final IUserRepository IUserRepository;

    @Autowired
    public UserService(IUserRepository IUserRepository) {
        this.IUserRepository = IUserRepository;
    }

    public User registerUser(User user) {

        return IUserRepository.save(user);
    }

}
