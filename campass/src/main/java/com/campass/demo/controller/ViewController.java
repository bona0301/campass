package com.campass.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {
	@Autowired
//	private ProductService service;

	@GetMapping("/product")
	public ModelAndView list() {
		return new ModelAndView("/product/product");
	}

	@GetMapping({"/", "/product/pcart"})
	public ModelAndView listCart() {
		return new ModelAndView("/product/pcart");
	}
	
	@GetMapping("/product/read")
	public void read() {

	}
}