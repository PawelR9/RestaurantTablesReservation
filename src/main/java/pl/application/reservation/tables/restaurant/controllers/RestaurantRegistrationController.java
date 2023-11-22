package pl.application.reservation.tables.restaurant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.application.reservation.tables.restaurant.model.dto.ClientRegistrationDTO;
import pl.application.reservation.tables.restaurant.model.dto.RestaurantRegistrationDTO;
import pl.application.reservation.tables.restaurant.services.UserService;

import java.sql.SQLIntegrityConstraintViolationException;

@Controller
@RequestMapping(path = "/restaurantRegistrationForm")
public class RestaurantRegistrationController {

    private final UserService userService;

    public RestaurantRegistrationController(UserService userService) {this.userService = userService;}

    @GetMapping
    public String showRestaurantRegistrationForm(@ModelAttribute("restaurant")RestaurantRegistrationDTO restaurantRegistrationDTO, Model model) {
        String error = (String) model.getAttribute("error");
        RestaurantRegistrationDTO restaurantRegistrationDTOModel = (RestaurantRegistrationDTO) model.getAttribute("model");
        model.addAttribute("restaurant", restaurantRegistrationDTOModel == null ? restaurantRegistrationDTO : restaurantRegistrationDTOModel);
        if (error != null && !error.isEmpty()) {
            model.addAttribute("errorMessage", error);
        }
        return "restaurantRegistrationForm";
    }

    @PostMapping("/registerRestaurant")
    public String registerRestaurant(RestaurantRegistrationDTO restaurantRegistrationDTO, RedirectAttributes redirectAttributes) {
        try {
            userService.registerRestaurant(restaurantRegistrationDTO);
            redirectAttributes.addFlashAttribute("correctRegistration", "Rejestracja przebiegła pomyślnie. Możesz spróbować się zalogować.");
            return "redirect:/login";
        } catch (SQLIntegrityConstraintViolationException e) {
            String message = e.getMessage();
            if (message.contains("o podanym adresie email.")) {
                redirectAttributes.addFlashAttribute("emailError", "Istnieje już konto o podanym adresie email.");
            } else if (message.contains("o podanym loginie.")) {
                redirectAttributes.addFlashAttribute("loginError", "Istnieje już konto o podanym loginie.");
            }

            redirectAttributes.addFlashAttribute("model", restaurantRegistrationDTO);
            return "redirect:/clientRegistrationForm";
        }
    }


}
