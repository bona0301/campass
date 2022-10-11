package com.campass.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ViewController {
	
	@GetMapping({"/", "/product/pcart"})
	public ModelAndView listCart(HttpSession session) {
		return new ModelAndView("/product/pcart");
	}
	
}	