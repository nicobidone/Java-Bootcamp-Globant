/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author nicob
 */
@Entity
@Setter
public class Product implements Serializable {

    @Id
    //@Column(name="product_id",unique = true)
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Getter
    private Integer id;
    
    @Getter
    private Integer quantity;
    
    @Getter
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
