/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class CartDto implements Serializable {
    
    private Integer id;
    
    private String description;
    
    private List<CartContentDto> cartcontent;
    
    @JsonIgnore
    private CustomerDto customer;
    
    
}