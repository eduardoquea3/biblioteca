package com.sise.biblioteca.middlewares;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sise.biblioteca.errors.ClientException;
import com.sise.biblioteca.shared.BaseResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ClientException.class)
    public ResponseEntity<BaseResponse> handleClientException(ClientException e){
        return new ResponseEntity<>(BaseResponse.error(e.getMessage()), e.geStatusCode());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse> handleGlobalException(Exception e){
        return new ResponseEntity<>(BaseResponse.error("Unexpected error!"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
