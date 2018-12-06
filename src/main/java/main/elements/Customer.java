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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer implements Serializable {

    @Id
    //@Column(name = "customer_id", unique = true)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    private String firstName;
    
    private String lastName;
    
    @OneToMany(mappedBy = "customer")
    private List<Cart> carts;

    //Constructors
    protected Customer() {
        carts = new ArrayList<>();
    }    
    
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.carts = new ArrayList<>();
    }

    //Getters
    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

//    public List<Cart> getCarts() {
//        return carts;
//    }

    //Setters
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }
    
    public void setCart(Cart cart) {
        this.carts.add(cart);
    }

    @Override
    public String toString() {
        return  "{" + 
                "\"id\" : " + id + ",\n" +
                "\"firstName\" : " + firstName + ",\n" + 
                "\"lastName\" : " + lastName + ",\n" + 
                "}";
    }    
    
}