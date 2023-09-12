package pl.application.reservation.tables.restaurant.controllers.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.application.reservation.tables.restaurant.model.dto.ClientRegistrationDTO;
import pl.application.reservation.tables.restaurant.services.ClientService;

@RestController
@RequestMapping(path = "api")
public class ClientRegistrationController {

    private final ClientService clientService;

    @Autowired
    public ClientRegistrationController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clientRegistrationForm")
    public String showClientRegistrationForm(Model model) {

        model.addAttribute("clientRegistrationDTO", new ClientRegistrationDTO());
        return "clientRegistrationForm";
    }


    @PostMapping("registerClient")
    public String registerClient (ClientRegistrationDTO clientRegistrationDTO) {
        clientService.registerClient(clientRegistrationDTO);
        return "redirect:api/clientRegistrationForm";
    }
}
