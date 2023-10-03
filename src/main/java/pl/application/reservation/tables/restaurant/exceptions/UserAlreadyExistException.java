package pl.application.reservation.tables.restaurant.exceptions;

import java.sql.SQLIntegrityConstraintViolationException;

public class UserAlreadyExistException extends SQLIntegrityConstraintViolationException {
}
