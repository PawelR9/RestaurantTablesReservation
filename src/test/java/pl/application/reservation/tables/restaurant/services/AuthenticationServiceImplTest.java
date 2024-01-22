package pl.application.reservation.tables.restaurant.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import pl.application.reservation.tables.restaurant.model.User;
import pl.application.reservation.tables.restaurant.repository.IUserRepository;
import pl.application.reservation.tables.restaurant.session.SessionData;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;


class AuthenticationServiceImplTest {


    @Mock
    private IUserRepository userRepository;

    @Mock
    private SessionData sessionData;

    @InjectMocks
    private AuthenticationServiceImpl authenticationService;

    @Test
    void testAuthenticateWithValidCredentials() {
        User user = new User();
        user.setId(1);
        user.setLogin("testuser");
        user.setEmail("test@example.com");
        user.setPassword("5f4dcc3b5aa765d61d8327deb882cf99");

        Mockito.when(userRepository.findByLogin(anyString())).thenReturn(Optional.of(user));

        boolean result = authenticationService.authenticate("testuser", "password");

        assertTrue(result);
        assertNull(user.getPassword());
        Mockito.verify(sessionData).setUser(user);
    }

    @Test
    void testAuthenticateWithInvalidCredentials() {
        Mockito.when(userRepository.findByLogin(anyString())).thenReturn(Optional.empty());

        boolean result = authenticationService.authenticate("nonexistentuser", "wrongpassword");

        assertFalse(result);
        Mockito.verify(sessionData, Mockito.never()).setUser(Mockito.any()); // Ensure that sessionData.setUser was not called
    }

    @Test
    void testAuthenticatePasswordWithValidCredentials() {
        User user = new User();
        user.setId(1);
        user.setPassword("5f4dcc3b5aa765d61d8327deb882cf99");

        Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(user));


        boolean result = authenticationService.authenticatePassword(1, "password");

        assertTrue(result);
        Mockito.verify(sessionData).setUser(user);
    }

    @Test
    void testAuthenticatePasswordWithInvalidCredentials() {
        Mockito.when(userRepository.findById(1)).thenReturn(Optional.empty());

        boolean result = authenticationService.authenticatePassword(1, "wrongpassword");

        assertFalse(result);
        Mockito.verify(sessionData, Mockito.never()).setUser(Mockito.any()); // Ensure that sessionData.setUser was not called
    }
}


