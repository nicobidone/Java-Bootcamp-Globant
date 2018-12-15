/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import main.dto.CustomerDto;
import main.entity.Customer;
import main.services.CustomerService;
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
@Api(value = "Customers operations")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @ApiOperation(value="View the complete list of customers")
    @RequestMapping(value = "customers/", method = RequestMethod.GET)
    @ResponseBody
    public List<CustomerDto> listAllCustomers(){        
        List<CustomerDto> aux = new ArrayList<>();
        this.customerService.listAllCustomers().forEach((customer)->{
            aux.add(this.convertToDto(customer));
        });
        return aux;
    }
    
    @ApiOperation(value="View customers by code matching")
    @RequestMapping(value = "customers/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CustomerDto showCustomer(@PathVariable Integer id){
        return this.convertToDto(customerService.getCustomerById(id));        
    }
    
    @ApiOperation(value="Add a customer")
    @RequestMapping(value = "customer/", method = RequestMethod.PUT)
    @ResponseBody
    public List<CustomerDto> addCustomer(CustomerDto customer) throws ParseException{
        this.customerService.saveCustomer(this.convertToEntity(customer));
        return this.listAllCustomers();
    }
    
    @ApiOperation(value = "Remove a customer")
    @RequestMapping(value="customer/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public List<CustomerDto> deleteCustomer(@PathVariable Integer id) {
        this.customerService.deleteCustomer(id);
        return this.listAllCustomers();
    }
    
    private CustomerDto convertToDto(Customer customer) {
        return modelMapper.map(customer, CustomerDto.class);
    }
    
    private Customer convertToEntity(CustomerDto customerDto) throws ParseException {
        return modelMapper.map(customerDto, Customer.class);
    }
}
