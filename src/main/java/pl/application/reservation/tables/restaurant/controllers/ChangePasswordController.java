package pl.application.reservation.tables.restaurant.controllers;

import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.application.reservation.tables.restaurant.model.User;
import pl.application.reservation.tables.restaurant.model.dto.ChangePasswordDTO;
import pl.application.reservation.tables.restaurant.services.IAuthenticationService;
import pl.application.reservation.tables.restaurant.services.UserService;
import pl.application.reservation.tables.restaurant.session.SessionData;

@Controller
@RequiredArgsConstructor
@RequestMapping("/changePassword")
public class ChangePasswordController {

    @Resource
    SessionData sessionData;

    private final UserService userService;
    private final IAuthenticationService authenticationService;

    @GetMapping
    public String showChangePasswordForm(Model model) {
        User user = sessionData.getUser();
        if (user != null) {
            model.addAttribute("user", user);
            return "changePassword";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping
    public String changePassword(@ModelAttribute("user") ChangePasswordDTO changePasswordDTO, RedirectAttributes redirectAttributes) {
        User user = sessionData.getUser();

        if (user != null) {
            if (authenticationService.authenticatePassword(user.getId(), changePasswordDTO.getOldPassword())) {
                userService.changePassword(user.getId(),
                        changePasswordDTO);
                redirectAttributes.addFlashAttribute("passwordChanged", "Hasło zostało zmienione");
            } else {
                redirectAttributes.addFlashAttribute("incorrectPassword", "Niepoprawne hasło");
            }
        } else {
            return "redirect:/login";
        }
        return "redirect:/changePassword";
    }


}
