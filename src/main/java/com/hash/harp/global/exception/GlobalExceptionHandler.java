package com.hash.harp.global.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(HarpException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(HarpException e) {
        log.error(e.getMessage() + "\n \t {}", e);
        return new ResponseEntity<>(new ErrorResponse(e.getStatus().value(), e.getMessage(), "CUSTOM_ERROR"), e.getStatus());
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleBindException(BindException e) {
        Map<String, String> errorMap = new HashMap<>();

        for (FieldError error : e.getFieldErrors()) {
            errorMap.put(error.getField(), error.getDefaultMessage());
            log.error(
                    String.valueOf(HttpStatus.BAD_REQUEST.value()),
                            "400",
                            errorMap.toString()
            );
        }

        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleConstraintViolation(ConstraintViolationException e) {
        Map<String, String> errorMap = new HashMap<>();

        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            errorMap.put(violation.getPropertyPath().toString(), violation.getMessage());
            log.error(violation.toString());
        }

        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleServerException(Exception e) {

        String errorMessage = e.getMessage();

        log.error(errorMessage);
        return new ResponseEntity<>(
                new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal server error", "INTERNAL_ERROR"),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
