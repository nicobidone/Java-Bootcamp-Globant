/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.services;

import java.util.List;
import com.globant.bootcamp.entity.CartContent;

/**
 *
 * @author nicob
 */
public interface CartContentService {
        
    List<CartContent> listAllCartsContent();

    List<CartContent> getCartContentsById(Integer id);

    CartContent saveCartContent(CartContent cart);

    void deleteCartContent(Integer id);
}
