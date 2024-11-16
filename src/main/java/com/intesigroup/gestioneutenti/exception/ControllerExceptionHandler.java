package com.intesigroup.gestioneutenti.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
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

    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<?> exceptionHandler(UserNotFoundException ex, HttpServletRequest request) {
        return new ResponseEntity<>(new ErrorDetails(new Date(), ex.getMessage(), null), HttpStatus.NOT_FOUND);
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

    @ExceptionHandler(value = {DataIntegrityViolationException.class})
    public ResponseEntity<?> exceptionHandler(DataIntegrityViolationException ex, HttpServletRequest request) {
        return new ResponseEntity<>(new ErrorDetails(new Date(), ex.getMessage(), null), HttpStatus.BAD_REQUEST);
    }

}
