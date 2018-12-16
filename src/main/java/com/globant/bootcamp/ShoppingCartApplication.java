package com.globant.bootcamp;



import main.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import main.entity.Customer;
import main.repository.*;
import main.entity.Cart;
import main.entity.CartContent;
import main.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShoppingCartApplication {
        
        private static final Logger log = LoggerFactory.getLogger(ShoppingCartApplication.class);
    
	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartApplication.class, args);
	}
        
        @Bean
	public CommandLineRunner demo(CustomerRepository cusRep, CartRepository cartRep, ProductRepository prodRep, CartContentRepository ccontRep) {
		return (args) -> {
			// save a couple of customers
                        List<Customer> lisCustomer = new ArrayList<>();
			lisCustomer.add(new Customer("Jack", "Bauer"));
			lisCustomer.add(new Customer("Chloe", "O'Brian"));
			lisCustomer.add(new Customer("Kim", "Bauer"));
			lisCustomer.add(new Customer("David", "Palmer"));
			lisCustomer.add(new Customer("Michelle", "Dessler"));
                        
                        Cart ctg1 = new Cart("carniceria",lisCustomer.get(3));
                        Cart ctg2 = new Cart("verduleria",lisCustomer.get(3));
                        lisCustomer.get(3).setCarts(java.util.Arrays.asList(ctg2));
                        lisCustomer.get(3).setCarts(java.util.Arrays.asList(ctg1));
                        
                        List<Product> lisProduct1 = new ArrayList<>();
                        lisProduct1.add(new Product("Pavita sadia",10));
                        lisProduct1.add(new Product("Chorizo de cerdo",10));
                        lisProduct1.add(new Product("Bife de chorizo",10));
                        lisProduct1.add(new Product("Pollo granja tres arroyos",10));
                        lisProduct1.add(new Product("Tapa asado ternera",10));
                        lisProduct1.add(new Product("Pavita sadia",10));
                                              
                        List<Product> lisProduct2 = new ArrayList<>();
                        lisProduct2.add(new Product("Acelga atado",10));
                        lisProduct2.add(new Product("Ciruela Bandeja",10));
                        lisProduct2.add(new Product("Damascos bandeja",10));
                        lisProduct2.add(new Product("Lechuga manteca",10));
                        lisProduct2.add(new Product("Tomate redondo",10));
                        lisProduct2.add(new Product("Tomate cherry bandeja",10));
                                                
                        List<CartContent> cc1 = new ArrayList<>();
                        lisProduct1.forEach((product) -> {
                            CartContent cartContent = new CartContent(ctg1,product,3);
                            cc1.add(cartContent);
                            ctg1.setCartcontent(java.util.Arrays.asList(cartContent));
                            product.setCartcontent(java.util.Arrays.asList(cartContent));
                        });
                        
                        List<CartContent> cc2 = new ArrayList<>();
                        lisProduct2.forEach((product) -> {
                            CartContent cartContent = new CartContent(ctg2,product,4);
                            cc2.add(cartContent);
                            ctg2.setCartcontent(java.util.Arrays.asList(cartContent));
                            product.setCartcontent(java.util.Arrays.asList(cartContent));                           
                        });                        
                        
                        //Almaceno en repositorios                        
                        lisCustomer.forEach((customer)-> {
                            cusRep.save(customer);
                        });
                        
                        cartRep.save(ctg1);
                        lisProduct1.forEach((product) -> {
                            prodRep.save(product);
                        });                        
                        cc1.forEach((cartcontent) -> {
                            ccontRep.save(cartcontent);
                        }); 
                        
                        cartRep.save(ctg2);
                        lisProduct2.forEach((product) -> {
                            prodRep.save(product);
                        });
                        cc2.forEach((cartcontent) -> {
                            ccontRep.save(cartcontent);
                        });
                         
                        
		};
	}
}
