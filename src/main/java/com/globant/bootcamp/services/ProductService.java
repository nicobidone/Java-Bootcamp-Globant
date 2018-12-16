/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.services;

/**
 *
 * @author nicob
 */

import com.globant.bootcamp.entity.Product;
import java.util.List;

public interface ProductService {
    
    List<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);
}
