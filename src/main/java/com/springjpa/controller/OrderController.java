package com.springjpa.controller;

import com.springjpa.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Controller
public class OrderController {
    @Autowired
    ProductRepository productRepository;

    @RequestMapping("/order")
    public ModelAndView handleOrder(@RequestParam("id") Long id){
        ModelAndView modelAndView = new ModelAndView("order");
        modelAndView.addObject("product", Arrays.asList(productRepository.findOne(id)));
        modelAndView.addObject("id",id);
        return modelAndView;
    }
}
