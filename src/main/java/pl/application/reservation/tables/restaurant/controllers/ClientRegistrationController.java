package pl.application.reservation.tables.restaurant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/clientRegistrationForm")
public class ClientRegistrationController {

    @GetMapping
    public String showClientRegistrationForm() {
        return "clientRegistrationForm";
    }
}
