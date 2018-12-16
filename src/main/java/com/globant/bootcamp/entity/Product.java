/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author nicob
 */
@Entity
@Data
public class Product implements Serializable {

    @Id
    //@Column(name="product_id",unique = true)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    private Integer quantity;
    
    private String description;
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy = "product")
    private List<CartContent> cartcontent;

    //Constructors
    public Product(){
        this.cartcontent = new ArrayList<>();
    }

    public Product(String description, Integer quantity) {
        this.description = description;
        this.quantity = quantity;
        this.cartcontent = new ArrayList<>();
    }  
    
}
