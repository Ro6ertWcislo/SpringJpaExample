package com.springjpa.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springjpa.model.Customer;
import com.springjpa.repo.CustomerRepository;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
	@Autowired
	CustomerRepository repository;
	
	@RequestMapping("/")
	public ModelAndView process(){
		// save a single Customer
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		return modelAndView;

	}

}

