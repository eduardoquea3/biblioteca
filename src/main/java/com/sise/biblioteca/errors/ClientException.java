package com.sise.biblioteca.errors;

import org.springframework.http.HttpStatus;

public class ClientException extends Exception {
    private HttpStatus statusCode;
    public ClientException(String message, HttpStatus statusCode){
        super(message);
        this.statusCode = statusCode;
    }
    public HttpStatus geStatusCode(){
        return this.statusCode;
    }
}
