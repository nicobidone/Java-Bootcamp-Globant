/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.entity;

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
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Data
public class Cart implements Serializable {
    
    @Id
    //@Column(name="cart_id",unique = true)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    @Column(nullable=false)
    private String description;
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy = "cart")
    private List<CartContent> cartcontent;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="customer_id")
    private Customer customer;

    public Cart() {
        this.cartcontent = new ArrayList<>();
    }
    
    public Cart(String description, Customer customer) {
        this.description = description;
        this.customer = customer;
        this.cartcontent = new ArrayList<>();
    }       
}