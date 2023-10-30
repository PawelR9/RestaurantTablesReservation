package pl.application.reservation.tables.restaurant.exceptions;

import java.sql.SQLIntegrityConstraintViolationException;

public class UserWithThisEmailAlreadyExistException extends SQLIntegrityConstraintViolationException {
    private String message = "Istnieje już konto o podanym adresie email.";

    public String getMessage() {
        return message;
    }
}
