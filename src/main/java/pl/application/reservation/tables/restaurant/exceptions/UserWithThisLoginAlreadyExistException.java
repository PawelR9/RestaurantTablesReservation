package pl.application.reservation.tables.restaurant.exceptions;

import java.sql.SQLIntegrityConstraintViolationException;

public class UserWithThisLoginAlreadyExistException extends SQLIntegrityConstraintViolationException {
    private String message = "Istnieje już konto o podanym loginie.";
    public String getMessage() {
        return message;
    }

}
