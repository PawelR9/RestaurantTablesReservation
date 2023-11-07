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

    /*@PostMapping
    public String changeEmail(@ModelAttribute("user") ChangeEmailDTO changeEmailDTO, RedirectAttributes redirectAttributes, Model model)
            throws UserWithThisEmailAlreadyExistException {
        ChangeEmailDTO changeEmailDTOModel = (ChangeEmailDTO) model.getAttribute("user");
        model.addAttribute("user", changeEmailDTOModel == null ? changeEmailDTO : changeEmailDTOModel);
        try {
            User user = sessionData.getUser();
            if (user != null) {
                if (authenticationService.authenticate(user.getLogin(), changeEmailDTO.getPassword())) {
                    if(changeEmailDTO.getEmail().equals(user.getEmail())) {
                        redirectAttributes.addFlashAttribute("emailUnchanged", "Adres email pozostał bez zmian");
                    } else {
                        userService.changeEmail(user.getId(),
                                                changeEmailDTO.getEmail(),
                                                 LocalDateTime.now());
                        redirectAttributes.addFlashAttribute("emailChanged", "Adres email został pomyślnie zmieniony");
                    }
                } else {
                    redirectAttributes.addFlashAttribute("passwordError", "Błędne hasło");
                }

            } else {
                return "redirect:/login";
            }
        } catch (UserWithThisEmailAlreadyExistException e) {
            redirectAttributes.addFlashAttribute("emailError", "Istnieje już konto o podanym adresie email");
        }
        return "redirect:/changeEmail";
    }*/
    @PostMapping
    public String changeEmail(@ModelAttribute("user") ChangeEmailDTO changeEmailDTO, RedirectAttributes redirectAttributes, Model model)
            throws UserWithThisEmailAlreadyExistException {
        ChangeEmailDTO changeEmailDTOModel = (ChangeEmailDTO) model.getAttribute("user");
        model.addAttribute("user", changeEmailDTOModel == null ? changeEmailDTO : changeEmailDTOModel);
        try {
            User user = sessionData.getUser();
            if (user != null) {
                if (authenticationService.authenticate(user.getLogin(), changeEmailDTO.getPassword())) {
                    if (changeEmailDTO.getEmail().equals(user.getEmail())) {
                        redirectAttributes.addFlashAttribute("emailUnchanged", "Adres email pozostał bez zmian");
                    } else {
                        userService.changeEmail(user.getId(),
                                changeEmailDTO.getEmail(),
                                LocalDateTime.now());
                        redirectAttributes.addFlashAttribute("emailChanged", "Adres email został pomyślnie zmieniony");
                    }
                } else {
                    redirectAttributes.addFlashAttribute("passwordError", "Błędne hasło");
                }
            } else {
                return "redirect:/login";
            }
        } catch (UserWithThisEmailAlreadyExistException e) {
            redirectAttributes.addFlashAttribute("emailError", "Istnieje już konto o podanym adresie email");
        }
        return "redirect:/changeEmail";
    }

}
