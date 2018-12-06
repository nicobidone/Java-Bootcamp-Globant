/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.sql.SQLException;
import java.util.List;
import main.elements.Customer;
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
@Api(value = "Customers operations")
@RequestMapping(value = "/customer")
public class CustomerController {
    
    private CustomerService customerService;
    
    @Autowired
    public void setCustomerService(CustomerService customerService){
        this.customerService = customerService;
    }
    
    @ApiOperation(value="View the complete list of customers")
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public List<Customer> listAllCustomers() throws SQLException, Exception{        
        return this.customerService.listAllCustomers();
    }
    
    @ApiOperation(value="View customers by code matching")
    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public Customer showCustomer(@PathVariable Integer id){
        return customerService.getCustomerById(id);        
    }
    
    @ApiOperation(value="Add a customer")
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public String addCustomer(Customer customer){
        this.customerService.saveCustomer(customer);
        return "Product added sucessfully";
    }
    
    @ApiOperation(value = "Remove a customer")
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public String deleteCustomer(@PathVariable Integer id){
        this.customerService.deleteCustomer(id);
        return "Product remove successfully";
    }
    
}
