package com.intesigroup.gestioneutenti.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {UserNotFoundException.class, EmailAlreadyUsedException.class})
    public ResponseEntity<?> exceptionHandler(Exception ex, HttpServletRequest request) {

        HttpStatus status = ex instanceof UserNotFoundException ? HttpStatus.NOT_FOUND : HttpStatus.BAD_REQUEST;

        return new ResponseEntity<>(new ErrorDetails(new Date(), ex.getMessage(), null), status);
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    public ResponseEntity<?> exceptionHandler(ConstraintViolationException ex, HttpServletRequest request) {
        Map<String, Object> response = new HashMap<>();

        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        Map<String, String> violationDetails = new HashMap<>();
        for (ConstraintViolation<?> violation : violations) {
            violationDetails.put(
                    violation.getPropertyPath().toString(),
                    violation.getMessage()
            );
        }
        response.put("violations", violationDetails);

        return new ResponseEntity<>(new ErrorDetails(new Date(), "Validation Failed", response), HttpStatus.BAD_REQUEST);
    }

}
