/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.elements;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author nicob
 */
@Entity
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
    
    //Getters
    public Integer getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

//    public List<CartContent> getCartcontent() {
//        return cartcontent;
//    }
    
    //Setters
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCartcontent(List<CartContent> cartcontent) {
        this.cartcontent = cartcontent;
    }
    
    public void setCartcontent(CartContent cartcontent) {
        this.cartcontent.add(cartcontent);
    }
    
    
    
}
