package pl.application.reservation.tables.restaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.application.reservation.tables.restaurant.model.dto.ClientRegistrationDTO;
import pl.application.reservation.tables.restaurant.services.UserService;

import java.sql.SQLIntegrityConstraintViolationException;

@Controller
@RequestMapping(path = "/clientRegistrationForm")
public class ClientRegistrationController {

    private final UserService userService;

    @Autowired
    public ClientRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showClientRegistrationForm(@ModelAttribute("client") ClientRegistrationDTO clientRegistrationDTO, Model model) {
        String error = (String) model.getAttribute("error");
        ClientRegistrationDTO clientRegistrationDTOModel = (ClientRegistrationDTO) model.getAttribute("model");
        model.addAttribute("client", clientRegistrationDTOModel == null ? clientRegistrationDTO : clientRegistrationDTOModel);
        if (error != null && !error.isEmpty()) {
            model.addAttribute("errorMessage", error);
        }
        return "clientRegistrationForm";
    }

    @PostMapping("/registerClient")
    public String registerClient(ClientRegistrationDTO clientRegistrationDTO, RedirectAttributes redirectAttributes) {
        try {
            userService.registerClient(clientRegistrationDTO);
            redirectAttributes.addFlashAttribute("correctRegistration", "Rejestracja przebiegła pomyślnie. Możesz spróbować się zalogować.");
            return "redirect:/login";
        } catch (SQLIntegrityConstraintViolationException e) {
            String message = e.getMessage();
            if (message.contains("o podanym adresie email.")) {
                redirectAttributes.addFlashAttribute("emailError", "Istnieje już konto o podanym adresie email.");
            } else if (message.contains("o podanym loginie.")) {
                redirectAttributes.addFlashAttribute("loginError", "Istnieje już konto o podanym loginie.");
            }

            redirectAttributes.addFlashAttribute("model", clientRegistrationDTO);
            return "redirect:/clientRegistrationForm";
        }
    }
}
