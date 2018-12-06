/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.controllers;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nicob
 */
@RestController
@Api(value = "Online shopping cart")
@RequestMapping(value = "/cart-content")
public class CartContentController {
    
    
//    @ApiOperation(value="Add one product (id) to the shopping cart content")
//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
//    public String addProduct(@PathVariable String id){      
//        cat.addElement(catalogue.getById(id));
//        return "Sucessfully added";
//    }    
//    
//    @ApiOperation(value="Add (quantity) products to the shopping cart content")
//    @RequestMapping(value = "/{id}/{quantity}", method = RequestMethod.PUT, produces = "application/json")
//    public String addProduct(@PathVariable String id, @PathVariable Integer quantity){
//        cat.addElement(catalogue.getById(id),quantity);
//        return "Sucessfully added";
//    }    
//    
//    @ApiOperation(value="Delete every (code) product from the shopping cart content")
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public String delProduct(@PathVariable String id){
//        cat.removeElement(id);
//        return "Sucessfully deleted";
//    }    
//    
//    @ApiOperation(value="Delete (quantity) products from the shopping cart content")
//    @RequestMapping(value = "/{id}/{quantity}", method = RequestMethod.DELETE)
//    @ResponseBody
//    public String delProduct(@PathVariable String id, @PathVariable Integer quantity){
//        cat.removeElement(id,quantity);
//        return "Sucessfully deleted";
//    }
}
