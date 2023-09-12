package pl.application.reservation.tables.restaurant.controllers.rest;

import org.springframework.web.bind.annotation.*;
import pl.application.reservation.tables.restaurant.model.Client;

@RestController
@RequestMapping(path = "api/clientRegistrationForm")
public class ClientRegistrationController {

    @GetMapping
    public String showClientRegistrationForm() {
        return "api/clientRegistrationForm";
    }


    @PostMapping("api/registerClient")
    public String addClientToDatabase(@ModelAttribute Client client) {
        return "api/clientRegistrationForm";
    }
}
