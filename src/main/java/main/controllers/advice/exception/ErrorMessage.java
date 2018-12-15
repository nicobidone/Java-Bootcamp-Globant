/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.controllers.advice.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;


/**
 *
 * @author nicob
 */
@Data
public class ErrorMessage {
    
    private String error;
    private Integer code;
    private HttpStatus status;

    public ErrorMessage() {
    }
    public ErrorMessage(String error, Integer code, HttpStatus status) {
        this.error = error;
        this.code = code;
        this.status = status;
    }
}
