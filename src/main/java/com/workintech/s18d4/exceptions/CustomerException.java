package com.workintech.s18d4.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class CustomerException extends RuntimeException {

    private HttpStatus httpStatus;

    public CustomerException(String s, HttpStatus httpStatus) {
        super(s);
        this.httpStatus = httpStatus;
    }
}
