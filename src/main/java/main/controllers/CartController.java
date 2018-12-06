package main.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import main.elements.Cart;
import main.elements.Product;
import main.services.CartContentService;
import main.services.CartService;
import main.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nicob
 */

@RestController
@Api(value = "Online shopping cart")
@RequestMapping(value = "/cart")
public class CartController {

    private CartService cartService;
    private CartContentService cartContentService;
    private CustomerService customerService;
    
    @Autowired
    public void setCartService( CartService cartService, 
                                CartContentService cartContentService, 
                                CustomerService customerService){
        this.cartService = cartService;
        this.cartContentService = cartContentService;
        this.customerService = customerService;
    }
    
    @ApiOperation(value="View the complete list of carts")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Cart> listAllCarts(){
        return this.cartService.listAllCarts();
    }
    
    @ApiOperation(value="View cart by code matching")
    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public Cart showCart(@PathVariable Integer id){
        return this.cartService.getCartById(id);        
    }
    
    @ApiOperation(value="Add a cart")
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public String addCart(Cart cart){
        this.cartService.saveCart(cart);
        return "Product added sucessfully";
    }
    
    @ApiOperation(value = "Remove a cart")
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public String deleteCart(@PathVariable Integer id){
        this.cartService.deleteCart(id);
        return "Product remove successfully";
    }  
    
    @ApiOperation(value="Add a product to the cart")
    @RequestMapping(value = "/{id}/{id_prod}", method = RequestMethod.PUT)
    public String addCartContent(Product product){
        
        return "Product added sucessfully";
    }
    
}