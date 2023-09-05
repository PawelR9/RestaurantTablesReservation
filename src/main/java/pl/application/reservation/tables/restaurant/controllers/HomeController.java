package pl.application.reservation.tables.restaurant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/index")
public class HomeController {

    @GetMapping
    public String showHomePage() {
        return "index";
    }
}

