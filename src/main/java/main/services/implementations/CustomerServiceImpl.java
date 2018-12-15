/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.services.implementations;

import java.util.ArrayList;
import java.util.List;
import main.entity.Customer;
import main.repository.CustomerRepository;
import main.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nicob
 */
@Service
public class CustomerServiceImpl implements CustomerService{
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private CustomerRepository customerRepository;
    
    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    
    @Override
    public List<Customer> listAllCustomers() {
        logger.debug("listAllCustomers called");
        Iterable<Customer> findAll = customerRepository.findAll();
        List<Customer> aux = new ArrayList<>();
        for (Customer product : findAll) {
            aux.add(product);
        }
        return aux;
    }

    @Override
    public Customer getCustomerById(Integer id) {
        logger.debug("getCustomerById called");
        Customer orElse = customerRepository.findById(id).orElse(null); //orElse es para anular el optional de lista
        return orElse;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        logger.debug("saveCustomer called");
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Integer id) {
        logger.debug("deleteCustomer called");
        customerRepository.deleteById(id);
    }
    
}
