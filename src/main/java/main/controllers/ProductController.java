/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.controllers;

import main.elements.Cart;
import main.elements.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import main.services.ProductService;
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
@RequestMapping("/products")
@Api(value="onlinestore", description="Operations to products")
public class ProductController {
    
    private ProductService productService;
    
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    
    @ApiOperation(value="View the complete list of products")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Product> listAllProducts(){
        return this.productService.listAllProducts();
    }
    
    @ApiOperation(value="View products by code matching")
    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public Product showProduct(@PathVariable Integer id){
        return productService.getProductById(id);        
    }
    
    @ApiOperation(value="Add a product")
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public String addProduct(Product product){
        this.productService.saveProduct(product);
        return "Product added sucessfully";
    }
    
    @ApiOperation(value = "Remove a product")
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable Integer id){
        this.productService.deleteProduct(id);
        return "Product remove successfully";
    }
    
}
