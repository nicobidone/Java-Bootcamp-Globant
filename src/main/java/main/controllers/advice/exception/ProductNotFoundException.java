/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.controllers.advice.exception;

import lombok.Getter;

/**
 *
 * @author nicob
 */
@Getter
public class ProductNotFoundException extends RuntimeException{
    
    private final long id;

    public ProductNotFoundException(final long id) {
      super("Product could not be found with id: " + id);
      this.id = id;
    }
}
