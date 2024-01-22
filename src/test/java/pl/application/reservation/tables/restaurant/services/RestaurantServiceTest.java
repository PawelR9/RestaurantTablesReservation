package pl.application.reservation.tables.restaurant.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.application.reservation.tables.restaurant.model.Restaurant;
import pl.application.reservation.tables.restaurant.model.User;
import pl.application.reservation.tables.restaurant.repository.IRestaurantRepository;

import static org.mockito.Mockito.*;

class RestaurantServiceTest {

    @Mock
    private IRestaurantRepository restaurantRepository;

    @Mock
    private EmailService emailService;

    @InjectMocks
    private RestaurantService restaurantService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void updateRestaurantStatus_shouldUpdateStatusAndSendEmail_whenApproved() {
        User owner = new User();
        owner.setEmail("owner@example.com");
        Integer restaurantId = 1;
        Restaurant restaurant = new Restaurant();
        restaurant.setId(restaurantId);
        restaurant.setOwner(owner);
        restaurant.setStatus(Restaurant.Status.APPROVED);

        when(restaurantRepository.findById(restaurantId)).thenReturn(java.util.Optional.of(restaurant));

        restaurantService.updateRestaurantStatus(restaurantId, Restaurant.Status.APPROVED);

        verify(restaurantRepository, times(1)).save(restaurant);
        verify(emailService, times(1)).sendEmail(anyString(), eq("Twoja restauracja została zatwierdzona"), anyString());
    }

    @Test
    void updateRestaurantStatus_shouldUpdateStatusAndSendEmail_whenRejected() {
        User owner = new User();
        owner.setEmail("owner@example.com");
        Integer restaurantId = 1;
        Restaurant restaurant = new Restaurant();
        restaurant.setId(restaurantId);
        restaurant.setOwner(owner);
        restaurant.setStatus(Restaurant.Status.REJECTED);

        when(restaurantRepository.findById(restaurantId)).thenReturn(java.util.Optional.of(restaurant));

        restaurantService.updateRestaurantStatus(restaurantId, Restaurant.Status.REJECTED);

        verify(restaurantRepository, times(1)).save(restaurant);
        verify(emailService, times(1)).sendEmail(anyString(), eq("Twoja restauracja została odrzucona"), anyString());
    }
}

