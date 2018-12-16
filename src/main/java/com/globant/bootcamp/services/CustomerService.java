/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.services;

import java.util.List;
import com.globant.bootcamp.entity.Customer;

/**
 *
 * @author nicob
 */
public interface CustomerService {
    
    List<Customer> listAllCustomers();

    Customer getCustomerById(Integer id);

    Customer saveCustomer(Customer customer);

    void deleteCustomer(Integer id);
    
}
