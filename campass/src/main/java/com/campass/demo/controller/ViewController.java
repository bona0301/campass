package com.campass.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.campass.demo.service.PCartService;

@Controller
public class ViewController {
	
	@Autowired
	private PCartService pcservice;
	
	@GetMapping("/product/pcart")
	public ModelAndView list() {
		
		return new ModelAndView("/product/pcart");
	}
}
