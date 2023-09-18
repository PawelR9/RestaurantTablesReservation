package pl.application.reservation.tables.restaurant.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity(name = "tclients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private int client_id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String email;
    private String first_name;
    private String last_name;
    private String phone_number;
}