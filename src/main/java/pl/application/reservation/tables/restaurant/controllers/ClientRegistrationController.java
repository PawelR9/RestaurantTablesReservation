package pl.application.reservation.tables.restaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String showClientRegistrationForm(Model model) {
        model.addAttribute("clientRegistrationDTO", new ClientRegistrationDTO());
        return "clientRegistrationForm";
    }

    @PostMapping("/registerClient")
    public String registerClient(ClientRegistrationDTO clientRegistrationDTO) {
        try {
            clientService.registerClient(clientRegistrationDTO);
            return "redirect:/index";
        } catch (UserAlreadyExistException e) {
            return "redirect:/clientRegistrationForm";
        }

    }
}
