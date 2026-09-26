package it.domrita.learning.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Indica a Spring che questa classe contiene handler globali
// per le eccezioni lanciate dai Controller REST.
// Essendo gestita da Spring, questa classe diventa un Bean.
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Questo metodo è un exception handler:
    // viene eseguito automaticamente quando viene lanciata
    // una EmailAlreadyExistsException.
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<String> handleEmailAlreadyExists(
            EmailAlreadyExistsException exception) {

        // Trasforma l'eccezione in una risposta HTTP 409 Conflict
        // e usa il messaggio dell'eccezione come body della risposta.
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(exception.getMessage());
    }
}