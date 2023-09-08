package pl.application.reservation.tables.restaurant.session;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.application.reservation.tables.restaurant.model.User;

@NoArgsConstructor
@Getter
@Setter
@Component
@SessionScope
public class SessionData {
    private User user = null;
    private String info = null;

    public boolean isLogged() {
        return this.user != null;
    }

    public boolean isAdmin() {
        if(this.user == null) {
            return false;
        }
        return this.user.getRole() == User.Role.ADMIN;
    }

    public String getInfo() {
        if(this.info == null) {
            return "";
        } else {
            String temp = this.info;
            this.info = null;
            return temp;
        }
    }
}
