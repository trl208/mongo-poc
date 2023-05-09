package com.example.mongoCRUD.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Rajyalaxmi_Thumarada on 03-04-2023
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmployeeAlreadyExistsException extends RuntimeException{

    private String message;
    EmployeeAlreadyExistsException() {}

    public EmployeeAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }

}
