/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.services;

import java.util.List;
import main.elements.Cart;

/**
 *
 * @author nicob
 */
public interface CartService {
    
    List<Cart> listAllCarts();

    Cart getCartById(Integer id);

    Cart saveCart(Cart cart);

    void deleteCart(Integer id);
}
