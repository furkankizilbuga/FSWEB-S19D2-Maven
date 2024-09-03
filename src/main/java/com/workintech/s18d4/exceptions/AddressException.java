package com.workintech.s18d4.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class AddressException extends RuntimeException {

    private HttpStatus httpStatus;

    public AddressException(String s, HttpStatus httpStatus) {
        super(s);
        this.httpStatus = httpStatus;
    }
}
