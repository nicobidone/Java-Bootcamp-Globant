/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.elements;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author nicob
 */
@Entity
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
    
    
    //Constructors
    public CartContent(){
        
    }
    
    public CartContent(Cart cart, Product product, Integer amount){
        this.cart = cart;
        this.product = product;
        this.amount = amount;
    }
    
    //Getters
    public Integer getId() {
        return id;
    }

    public Integer getAmount() {
        return amount;
    }

    public Cart getCart() {
        return cart;
    }

    public Product getProduct() {
        return product;
    }

    //Setters
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
}
