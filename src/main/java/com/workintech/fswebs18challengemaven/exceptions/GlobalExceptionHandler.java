package com.workintech.fswebs18challengemaven.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    private ResponseEntity<CardErrorResponse> handleException(CardException exception){
        log.error("card exception occured! Exception details: ", exception);
        CardErrorResponse cardErrorResponse = new CardErrorResponse(exception.getMessage());
        return new ResponseEntity<>(cardErrorResponse, exception.getHttpStatus());
    }

    @ExceptionHandler
    private ResponseEntity<CardErrorResponse> handleGlobalException(Exception exception){
      log.error("card exception occured! Exception details: ", exception);
      CardErrorResponse cardErrorResponse = new CardErrorResponse(exception.getMessage());
      return new ResponseEntity<>(cardErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}