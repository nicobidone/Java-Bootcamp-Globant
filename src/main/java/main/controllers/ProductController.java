/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.controllers;

import main.entity.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import main.controllers.advice.exception.ProductNotFoundException;
import main.dto.ProductDto;
import main.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author nicob
 */
@RestController
@Api(description="Operations to products")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private ModelMapper modelMapper;
        
    @ApiOperation(value="View the complete list of products")
    @RequestMapping(value = "products/", method = RequestMethod.GET)    
    @ResponseBody
    public List<ProductDto> listAllProducts(){
        List<ProductDto> aux = new ArrayList<>();
        this.productService.listAllProducts().forEach((product) -> {
            aux.add(this.convertToDto(product,product.getId()));
        });
        return aux;
    }
    
    @ApiOperation(value="View products by code matching")
    @RequestMapping(value = "products/{id}", method = RequestMethod.GET)    
    @ResponseBody
    public ProductDto showProduct(@PathVariable Integer id){
        return this.convertToDto(productService.getProductById(id),id);        
    }
    
    @ApiOperation(value="Add a product")
    @RequestMapping(value = "product/", method = RequestMethod.PUT)
    @ResponseBody
    public List<ProductDto> addProduct(ProductDto product) throws ParseException{
        this.productService.saveProduct(this.convertToEntity(product));
        return this.listAllProducts();
    }
    
    @ApiOperation(value = "Remove a product")
    @RequestMapping(value="product/{id}", method = RequestMethod.DELETE)    
    @ResponseBody
    public List<ProductDto> deleteProduct(@PathVariable Integer id){
        this.productService.deleteProduct(id);
        return this.listAllProducts();
    }    
    
    private ProductDto convertToDto(Product product, Integer id) {
        if (product == null)
            throw  new ProductNotFoundException(id);
        return modelMapper.map(product, ProductDto.class);
    }
    
    private Product convertToEntity(ProductDto productDto) throws ParseException {
        if (productDto == null)
            throw  new ProductNotFoundException(0);
        return modelMapper.map(productDto, Product.class);
    }
}
