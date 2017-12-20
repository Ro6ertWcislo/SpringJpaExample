package com.springjpa.controller;

import com.springjpa.model.Customer;
import com.springjpa.repo.CustomerRepository;
import com.springjpa.repo.ProductRepository;
import com.springjpa.utils.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    Generator generator;


    @RequestMapping("/products")
    public ModelAndView DisplayProductList(){
        if (productRepository.count() ==0)
            generator.generate(5);

        ModelAndView modelAndView = new ModelAndView("productList");
        modelAndView.addObject("products",productRepository.findAll());
        return modelAndView;
    }





}
