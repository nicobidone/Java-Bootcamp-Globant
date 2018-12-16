/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author nicob
 */
@Entity
@Data
public class CartContent implements Serializable {
    
    @Id
    //@Column(name="cartcontent_id",unique = true)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    private Integer amount;
    
    //@OneToOne(fetch=FetchType.LAZY)
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cart_id")
    private Cart cart;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Product product;

    public CartContent() {
    }
    
    public CartContent(Cart cart, Product product, Integer amount){
        this.cart = cart;
        this.product = product;
        this.amount = amount;
    }
    
}
