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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
        
@Entity
@Data
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
    
}