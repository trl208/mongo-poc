package com.example.mongoCRUD.handler;

import com.example.mongoCRUD.exceptions.EmployeeAlreadyExistsException;
import com.example.mongoCRUD.exceptions.ErrorResponse;
import com.example.mongoCRUD.exceptions.NoSuchEmployeeExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Rajyalaxmi_Thumarada on 02-04-2023
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value
            = NoSuchEmployeeExistsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorResponse handleException(NoSuchEmployeeExistsException ex)
    {
        return new ErrorResponse(
                HttpStatus.NOT_FOUND.value(), ex.getMessage());
       // return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ExceptionHandler(value = EmployeeAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleEmployeeAlreadyExistsException(EmployeeAlreadyExistsException ex) {
        return new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(), ex.getMessage() );
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
     public @ResponseBody ErrorResponse handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Please enter valid input ");
    }
}
