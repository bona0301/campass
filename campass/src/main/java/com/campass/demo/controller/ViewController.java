package com.campass.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.campass.demo.service.ProductService;

@Controller
public class ViewController {
	@Autowired
	private ProductService service;
	
	@GetMapping({"/","/product/product"})
	public ModelAndView list() {
		return new ModelAndView("/product");
	}

	@GetMapping({"/", "/product/pcart"})
	public ModelAndView listCart(HttpSession session) {
		return new ModelAndView("/product/pcart");
	}
}

