package pl.application.reservation.tables.restaurant.controllers;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.application.reservation.tables.restaurant.exceptions.UserValidationException;
import pl.application.reservation.tables.restaurant.services.IAuthenticationService;
import pl.application.reservation.tables.restaurant.session.SessionData;

@Controller
public class AuthenticationController {

    @Autowired
    IAuthenticationService authenticationService;

    @Resource
    SessionData sessionData;

    @GetMapping("/login")
    public String login(Model model) {
        ModelUtils.addCommonDataToModel(model, this.sessionData);
        model.addAttribute("info", this.sessionData.getInfo());
        return "login";
    }

    @PostMapping("login")
    public String login(@RequestParam String email,
                        @RequestParam String password) {
        try {
            this.authenticationService.authenticate(email, password);
            if (sessionData.isLogged()) {
                return "redirect:/index";
            }
        } catch (UserValidationException e) {
        }
        this.sessionData.setInfo("Niepoprawny login lub hasło");
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        this.authenticationService.logout(request);
        return "redirect:/index";
    }

}
