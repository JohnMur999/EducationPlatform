package ru.johnmur.EducationPlatform.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleResponseStatusException(ResponseStatusException e) {
        return new ResponseEntity<>(e.getReason(), e.getStatusCode());
    }

    @ExceptionHandler
    public ResponseEntity<String> handleRuntimeException (RuntimeException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
