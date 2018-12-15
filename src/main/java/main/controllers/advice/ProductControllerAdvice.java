/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.controllers.advice;

import main.controllers.advice.exception.ProductNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Optional;
import main.controllers.advice.exception.ErrorMessage;

/**
 *
 * @author nicob
 */
@ControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class ProductControllerAdvice extends ResponseEntityExceptionHandler 
{
    
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorMessage notFoundException(ProductNotFoundException e) {
      return error(e, HttpStatus.NOT_FOUND, String.valueOf(e.getId()));
    }
    
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorMessage assertionException(final IllegalArgumentException e) {
        return error(e, HttpStatus.NOT_FOUND, e.getLocalizedMessage());
    }
    
    private ErrorMessage error(final Exception exception, final HttpStatus httpStatus, final String logRef) {
        final String message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        return new ErrorMessage(message,404,httpStatus);
    }
    
    

}
