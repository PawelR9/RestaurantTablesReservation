package pl.application.reservation.tables.restaurant.controllers;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.application.reservation.tables.restaurant.model.Restaurant;
import pl.application.reservation.tables.restaurant.model.User;
import pl.application.reservation.tables.restaurant.services.IRestaurantService;
import pl.application.reservation.tables.restaurant.session.SessionData;

import java.util.List;

@Controller
@RequestMapping(path = "/index")
public class HomeController {

    @Resource
    SessionData sessionData;

    @Autowired
    private IRestaurantService restaurantService;

    @GetMapping
    public ModelAndView showHomePage() {
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("restaurants", restaurants);
        if (sessionData.isLogged()) {
            User user = sessionData.getUser();
            ModelUtils.addCommonDataToModel(modelAndView.getModelMap(), this.sessionData);
            modelAndView.addObject("logged", true);
            modelAndView.addObject("user", user);
        }
       return modelAndView;
    }
}

