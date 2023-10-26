package pl.application.reservation.tables.restaurant.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.application.reservation.tables.restaurant.services.UserService;

public class UserController {
    private UserService userService;

    @PostMapping("/updateUser")
    public String updateUser(@RequestParam Long userId, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String phoneNumber) {
        userService.updateUserData(userId, firstName, lastName, phoneNumber);
        return "redirect:/main";
}
}
