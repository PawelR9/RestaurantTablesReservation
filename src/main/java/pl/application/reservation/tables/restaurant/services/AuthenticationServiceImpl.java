package pl.application.reservation.tables.restaurant.services;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.application.reservation.tables.restaurant.model.User;
import pl.application.reservation.tables.restaurant.repository.IUserRepository;
import pl.application.reservation.tables.restaurant.session.SessionData;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

    @Autowired
    IUserRepository userRepository;
    @Autowired
    EmailService emailService;
    @Resource
    SessionData sessionData;

    @Override
    public boolean authenticate(String loginOrEmail, String password) {
        Optional<User> userBox;
        if (loginOrEmail.contains("@")) {
            userBox = this.userRepository.findByEmail(loginOrEmail.toLowerCase());
        } else {
            userBox = this.userRepository.findByLogin(loginOrEmail.toLowerCase());
        }
        if (userBox.isPresent() && userBox.get().getPassword().equals(DigestUtils.md5Hex(password))) {
            userBox.get().setPassword(null);
            this.sessionData.setUser(userBox.get());
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean authenticatePassword(int id, String password) {
        Optional<User> userBox;
        userBox = this.userRepository.findById(id);
        if(userBox.isPresent() && userBox.get().getPassword().equals(DigestUtils.md5Hex(password))) {
            this.sessionData.setUser(userBox.get());
            return true;
        } else {
            return false;
        }
    }


    @Override
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}

