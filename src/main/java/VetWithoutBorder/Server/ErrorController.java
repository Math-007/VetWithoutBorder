package VetWithoutBorder.Server;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.PersistenceException;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(value = EntityNotFoundError.class)
    public ResponseEntity<QueryError> entityNotFound(EntityNotFoundError exception) {
        return new ResponseEntity<>(exception.errorMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = PersistenceException.class)
    public ResponseEntity<QueryError> sqlError(PersistenceException exception) {
        return new ResponseEntity<>(new QueryError(exception.getCause().getCause().getMessage()), HttpStatus.BAD_REQUEST);
    }
}
