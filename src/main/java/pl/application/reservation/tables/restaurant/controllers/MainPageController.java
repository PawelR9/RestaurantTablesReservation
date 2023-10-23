package pl.application.reservation.tables.restaurant.controllers;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.application.reservation.tables.restaurant.model.User;
import pl.application.reservation.tables.restaurant.session.SessionData;

@Controller
public class MainPageController {

    @Resource
    SessionData sessionData;

    @GetMapping("main")
    public String showMainPage(Model model) {
        if (sessionData.isLogged()) {
            User user = sessionData.getUser();
            model.addAttribute("logged", true);
            model.addAttribute("user", user);
            return "main";
        }return "login";
    }
}
