package pl.application.reservation.tables.restaurant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginPageController {
    @GetMapping("loginPage")
    public String showLoginPage(Model model) {
        String correctRegistration = (String) model.getAttribute("correctRegistration");
        if(correctRegistration != null && !correctRegistration.isEmpty()) {
            model.addAttribute("correctRegistrationMessage", correctRegistration);
        }
        return "login";
    }
}
