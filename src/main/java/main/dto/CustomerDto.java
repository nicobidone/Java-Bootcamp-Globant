 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.dto;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class CustomerDto implements Serializable {

    private Integer id;
    
    private String firstName;
    
    private String lastName;
    
    private List<CartDto> carts;

    @Override
    public String toString() {
        return  "{" + 
                "\"id\" : " + id + ",\n" +
                "\"firstName\" : " + firstName + ",\n" + 
                "\"lastName\" : " + lastName + ",\n" + 
                "}";
    }    
    
}