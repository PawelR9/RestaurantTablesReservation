package pl.application.reservation.tables.restaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.application.reservation.tables.restaurant.exceptions.UserAlreadyExistException;
import pl.application.reservation.tables.restaurant.model.dto.ClientRegistrationDTO;
import pl.application.reservation.tables.restaurant.services.ClientService;

@Controller
@RequestMapping(path = "/clientRegistrationForm")
public class ClientRegistrationController {

    private final ClientService clientService;

    @Autowired
    public ClientRegistrationController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping()
    public String showClientRegistrationForm(@ModelAttribute("client") ClientRegistrationDTO clientRegistrationDTO, Model model) {
        String error = (String) model.getAttribute("error");
        ClientRegistrationDTO clientRegistrationDTOModel = (ClientRegistrationDTO) model.getAttribute("model");
        model.addAttribute("client", clientRegistrationDTOModel == null ? clientRegistrationDTO : clientRegistrationDTOModel);
        if(error != null && !error.isEmpty()){
            model.addAttribute("errorMessage", error);
        }
        return "clientRegistrationForm";
    }

    @PostMapping("/registerClient")
    public String registerClient(ClientRegistrationDTO clientRegistrationDTO, RedirectAttributes redirectAttributes) {
        try {
            clientService.registerClient(clientRegistrationDTO);
            redirectAttributes.addFlashAttribute("correctRegistration", "Rejestracja przebieg³a pomyœlnie. Mo¿esz spróbowaæ siê zalogowaæ.");
            return "redirect:/login";
        } catch (UserAlreadyExistException e) {
            redirectAttributes.addFlashAttribute("error", "Istnieje ju¿ konto o podanym adresie email.");
            redirectAttributes.addFlashAttribute("model", clientRegistrationDTO);
            return "redirect:/clientRegistrationForm";
        }
    }
}
