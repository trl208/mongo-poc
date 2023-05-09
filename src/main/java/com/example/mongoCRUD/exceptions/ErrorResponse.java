package com.example.mongoCRUD.exceptions;

/**
 * Rajyalaxmi_Thumarada on 02-04-2023
 */
public class ErrorResponse {

    private int statusCode;
    private String message;

    public ErrorResponse(int value, String message) {
       // super();
        this.message = message;
    }
}
