package pl.application.reservation.tables.restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

@Entity(name = "tusers")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String first_name;
    private String last_name;
    @Column(unique = true)
    private String email;
    @JsonIgnore
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String phone_number;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public static User copyOf(User user) {
        User result = new User();
        result.id = user.id;
        result.first_name = user.first_name;
        result.last_name = user.last_name;
        result.email = user.email;
        result.password = user.password;
        result.role = user.role;
        result.phone_number = user.phone_number;
        result.created_at = user.created_at;
        result.updated_at = user.updated_at;
        return result;
    }

    public enum Role {
        ADMIN,
        CUSTOMER,
        RESTAURANT_OWNER,
    }
}
