package com.workintech.s18d4.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> exceptionHandler(AddressException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getLocalizedMessage());
        return new ResponseEntity<>(errorResponse, exception.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> exceptionHandler(AccountException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getLocalizedMessage());
        return new ResponseEntity<>(errorResponse, exception.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> exceptionHandler(CustomerException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getLocalizedMessage());
        return new ResponseEntity<>(errorResponse, exception.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getLocalizedMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
