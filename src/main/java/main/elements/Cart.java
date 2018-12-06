/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.elements;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cart implements Serializable {
    
    @Id
    //@Column(name="cart_id",unique = true)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    @Column(nullable=false)
    private String description;
    
    //@OneToOne(fetch=FetchType.LAZY, mappedBy = "cart")
    //private CartContent cartcontent;
    @OneToMany(fetch=FetchType.LAZY, mappedBy = "cart")
    private List<CartContent> cartcontent;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="customer_id")
    private Customer customer;
    
    //Constructors
    public Cart(){
        this.cartcontent = new ArrayList<>();        
    }

    public Cart(String description, Customer customer) {
        this.description = description;
        this.customer = customer;
        this.cartcontent = new ArrayList<>();
    }

    //Getters
    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

//    public List<CartContent> getCartcontent() {
//        return cartcontent;
//    }
    
    public Customer getCustomer() {
        return customer;
    }

    //Setters
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCartcontent(List<CartContent> cartcontent) {
        this.cartcontent = cartcontent;
    }    
    
    public void setCartcontent(CartContent cartcontent) {
        this.cartcontent.add(cartcontent);
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    
}