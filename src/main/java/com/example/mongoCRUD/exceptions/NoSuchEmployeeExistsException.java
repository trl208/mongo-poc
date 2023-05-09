package com.example.mongoCRUD.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Rajyalaxmi_Thumarada on 02-04-2023
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoSuchEmployeeExistsException extends  RuntimeException{

    private String message;

    NoSuchEmployeeExistsException() {

    }


    public NoSuchEmployeeExistsException(String message) {
        super(message);
        this.message = message;
    }

}
