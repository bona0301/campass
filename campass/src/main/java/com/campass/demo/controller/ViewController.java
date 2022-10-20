package com.campass.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ViewController {
	@GetMapping("/product")
	public ModelAndView list() {
		return new ModelAndView("/product/product");
		
		
	}
	
	@GetMapping("/product/product_detail")
	public void read() {

	}

	@GetMapping({"/", "/product/pcart"})
	public ModelAndView listCart() {
		return new ModelAndView("/product/pcart");
	}

}