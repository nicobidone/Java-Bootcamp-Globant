/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.services.implementations;

/**
 *
 * @author nicob
 */

import java.util.ArrayList;
import java.util.List;
import com.globant.bootcamp.entity.Product;
import com.globant.bootcamp.repository.ProductRepository;
import com.globant.bootcamp.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> listAllProducts() {
        logger.debug("listAllProducts called");
        Iterable<Product> findAll = productRepository.findAll();
        List<Product> aux = new ArrayList<>();
        for (Product product : findAll) {
            aux.add(product);
        }
        return aux;
    }

    @Override
    public Product getProductById(Integer id) {
        logger.debug("getProductById called");
        return productRepository.findById(id).orElse(null); //orElse es para anular el optional de lista        
    }

    @Override
    public Product saveProduct(Product product) {
        logger.debug("saveProduct called");
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        logger.debug("deleteProduct called");
        productRepository.deleteById(id);
    }
    
    public void editProductQuantity(Integer id, Integer quantity){
        logger.debug("deleteProductQuantity called");
        Product aux = this.getProductById(id);
        aux.setQuantity(aux.getQuantity()+quantity);
    }
}
