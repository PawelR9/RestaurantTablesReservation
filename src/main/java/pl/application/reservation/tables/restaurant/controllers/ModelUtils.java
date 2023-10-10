package pl.application.reservation.tables.restaurant.controllers;

import org.springframework.ui.Model;
import pl.application.reservation.tables.restaurant.session.SessionData;

public class ModelUtils {
    public static void addCommonDataToModel(Model model, SessionData sessionData) {
        model.addAttribute("logged", sessionData.isLogged());
        model.addAttribute("admin",sessionData.isAdmin());
    }
}
