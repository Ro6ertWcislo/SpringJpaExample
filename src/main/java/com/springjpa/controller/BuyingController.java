package com.springjpa.controller;

import com.springjpa.model.Customer;
import com.springjpa.model.Product;
import com.springjpa.model.ProductTransaction;
import com.springjpa.model.StoreTransaction;
import com.springjpa.repo.CustomerRepository;
import com.springjpa.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.bind.SchemaOutputResolver;
import java.util.List;


@Controller
public class BuyingController {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @RequestMapping("/buy")
    public String handleBuy(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,@RequestParam("id") Long id){
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(id);
        Product product = productRepository.findOne(id);
        List<Customer> customers =  customerRepository.findByLastNameAndAndFirstName(lastName,firstName);
        Customer customer;
        if (customers.isEmpty()){
             customer= new Customer(firstName,lastName);
            customerRepository.save(customer);
        }else
            customer = customers.get(0);
        StoreTransaction storeTransaction= new StoreTransaction();
        storeTransaction.setCustomer(customer);
        ProductTransaction productTransaction= new ProductTransaction();
        productTransaction.setQuantity(1);
        productTransaction.setProduct(product);
        productTransaction.setStoreTransaction(storeTransaction);
        storeTransaction.addProductTransaction(productTransaction);
        product.addProductTransaction(productTransaction);
        product.setUnitsPerStock(product.getUnitsPerStock()-1);
        customer.addTransaction(storeTransaction);
        customerRepository.save(customer);

        return "home";
    }
}
