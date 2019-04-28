package VetWithoutBorder.Server;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(value = EntityNotFoundError.class)
    public ResponseEntity<QueryError> entityNotFound(EntityNotFoundError exception) {
        return new ResponseEntity<>(exception.errorMessage(), HttpStatus.NOT_FOUND);
    }
}
