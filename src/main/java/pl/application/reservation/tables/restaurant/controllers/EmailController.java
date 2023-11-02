package pl.application.reservation.tables.restaurant.controllers;

import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.application.reservation.tables.restaurant.exceptions.UserWithThisEmailAlreadyExistException;
import pl.application.reservation.tables.restaurant.model.User;
import pl.application.reservation.tables.restaurant.model.dto.ChangeEmailDTO;
import pl.application.reservation.tables.restaurant.model.dto.UpdateClientDTO;
import pl.application.reservation.tables.restaurant.services.AuthenticationServiceImpl;
import pl.application.reservation.tables.restaurant.services.UserService;
import pl.application.reservation.tables.restaurant.session.SessionData;

import java.time.LocalDateTime;

@Controller
@AllArgsConstructor
@RequestMapping("/changeEmail")
public class EmailController {

    @Resource
    SessionData sessionData;

    private final UserService userService;
    private final AuthenticationServiceImpl authenticationService;

    @GetMapping
    public String showChangeEmailForm() {
        User user = sessionData.getUser();
        if (user != null) {
            return "changeEmail";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping
    public String changeEmail(@ModelAttribute ChangeEmailDTO changeEmailDTO, RedirectAttributes redirectAttributes)
            throws UserWithThisEmailAlreadyExistException {
        try {
            authenticationService.authenticatePassword(changeEmailDTO.getPassword());
            User user = sessionData.getUser();
            if (user != null) {
                userService.changeEmail(user.getId(),
                        changeEmailDTO.getEmail(),
                        LocalDateTime.now());
                redirectAttributes.addFlashAttribute("correctSave", "Email został poprawnie zmieniony");
            } else {
                return "redirect:/login";
            }
        } catch (UserWithThisEmailAlreadyExistException e) {
            redirectAttributes.addFlashAttribute("emailError", "Istnieje już konto o podanym adresie email");
        }
        return "redirect:/changeEmail";
    }

}
