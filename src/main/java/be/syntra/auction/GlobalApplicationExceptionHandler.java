package be.syntra.auction;

import be.syntra.auction.exceptions.EntityNotFoundException;
import be.syntra.auction.exceptions.ErrorResponse;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

@RestControllerAdvice
public class GlobalApplicationExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Object> handleResourceNotFoundException(RuntimeException ex) {
        ErrorResponse error = new ErrorResponse(Arrays.asList(ex.getMessage()));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({IllegalArgumentException.class, MismatchedInputException.class})
        public ResponseEntity<Object> handleInvalidCredentialsException(Throwable ex) {
            ErrorResponse error = new ErrorResponse((Arrays.asList(ex.getMessage())));
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }


}
