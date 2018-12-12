/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.dto;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author nicob
 */
@Data
public class CartContentDto implements Serializable {
    
    private Integer id;
    
    private Integer amount;
    
    private CartDto cart;
    
    private ProductDto product;    
    
    
}
