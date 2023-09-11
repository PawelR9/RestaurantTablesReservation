//package pl.application.reservation.tables.restaurant.controllers.rest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import pl.application.reservation.tables.restaurant.model.User;
//import pl.application.reservation.tables.restaurant.services.UserService;
//@RestController
//@RequestMapping("/api/users")
//public class UserController {
//
//    private final UserService userService;
//    private final PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
//        this.userService = userService;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @PostMapping("/register/customer")
//    public ResponseEntity<User> registerCustomer(@RequestBody User user) {
//        // Sprawdź, czy użytkownik o podanym adresie email już istnieje
//        if (userService.findByEmail(user.getEmail()).isPresent()) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body(null); // Tutaj możesz obsłużyć sytuację, gdy użytkownik już istnieje
//        }
//
//        // Zakoduj hasło przed zapisem do bazy danych
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setRole(User.Role.CUSTOMER); // Ustaw rolę na klienta
//        User registeredUser = userService.registerCustomer(user);
//        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
//    }
//
//    @PostMapping("/register/restaurant-owner")
//    public ResponseEntity<User> registerRestaurantOwner(@RequestBody User user) {
//        // Sprawdź, czy użytkownik o podanym adresie email już istnieje
//        if (userService.findByEmail(user.getEmail()).isPresent()) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body(null); // Tutaj możesz obsłużyć sytuację, gdy użytkownik już istnieje
//        }
//
//        // Zakoduj hasło przed zapisem do bazy danych
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setRole(User.Role.RESTAURANT_OWNER); // Ustaw rolę na właściciela restauracji
//        User registeredUser = userService.registerRestaurantOwner(user);
//        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
//    }
//}
