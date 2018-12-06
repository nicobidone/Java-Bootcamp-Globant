/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.services.implementations;

import java.util.ArrayList;
import java.util.List;
import main.elements.Cart;
import main.repository.CartRepository;
import main.services.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nicob
 */
@Service
public class CartServiceImpl implements CartService{
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private CartRepository cartRepository;

    @Autowired
    public void setProductRepository(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public List<Cart> listAllCarts() {
        logger.debug("listAllCarts called");
        Iterable<Cart> findAll = cartRepository.findAll();
        List<Cart> aux = new ArrayList<>();
        for (Cart product : findAll) {
            aux.add(product);
        }
        return aux;
    }

    @Override
    public Cart getCartById(Integer id) {
        logger.debug("getCartById called");
        return cartRepository.findById(id).orElse(null); //orElse es para anular el optional de lista  
    }

    @Override
    public Cart saveCart(Cart cart) {
        logger.debug("saveCart called");
        return cartRepository.save(cart);
    }

    @Override
    public void deleteCart(Integer id) {
        logger.debug("deleteCart called");
        cartRepository.deleteById(id);
    }
    
}
