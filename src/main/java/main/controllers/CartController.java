package main.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import main.entity.Product;
import main.entity.Cart;
import main.entity.CartContent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import main.dto.CartDto;
import main.dto.ProductDto;
import main.services.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nicob
 */

@RestController
@Api(value = "Online shopping cart")
public class CartController {
    
    @Autowired
    private CartService cartService;
    
    @Autowired
    private CartContentService cartContentService;
    
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private ProductService productService;

    @Autowired
    private ModelMapper modelMapper;    
    
    @ApiOperation(value="View the complete list of carts")
    @RequestMapping(value = "carts/", method = RequestMethod.GET)
    @ResponseBody
    public List<CartDto> listAllCarts(){
        List<CartDto> aux = new ArrayList<>();
        this.cartService.listAllCarts().forEach((cart) -> {
            aux.add(this.convertToDto(cart));
        });
        return aux;
    }
    
    @ApiOperation(value="View cart by code matching")
    @RequestMapping(value = "carts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CartDto showCart(@PathVariable Integer id){
        return this.convertToDto(this.cartService.getCartById(id));        
    }
    
    @ApiOperation(value="Add a cart")
    @RequestMapping(value = "cart/", method = RequestMethod.PUT)
    @ResponseBody
    public List<CartDto> addCart(CartDto cart) throws ParseException{
        this.cartService.saveCart(this.convertToEntity(cart));
        return this.listAllCarts();
    }
    
    @ApiOperation(value = "Remove a cart")
    @RequestMapping(value="cart/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public List<CartDto> deleteCart(@PathVariable Integer id){
        this.cartService.deleteCart(id);
        return this.listAllCarts();
    }  
    
    @ApiOperation(value="Add a product to the cart")
    @RequestMapping(value = "cart/{id}/product/{id_prod}/{quantity}", method = RequestMethod.PUT)
    public String addCartContent(   @PathVariable Integer id, 
                                    @PathVariable Integer id_prod, 
                                    @PathVariable Integer quantity){
        Cart auxC = this.cartService.getCartById(id);
        Product auxP = this.productService.getProductById(id_prod);
        
        CartContent auxCC = new CartContent(auxC, auxP, quantity);
        this.cartContentService.saveCartContent(auxCC);
        return "Product added sucessfully";
    }
    
    private CartDto convertToDto(Cart cart) {
        return modelMapper.map(cart, CartDto.class);
    }
    
    private Cart convertToEntity(CartDto cartDto) throws ParseException {
        return modelMapper.map(cartDto, Cart.class);
    }
    
}