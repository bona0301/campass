package com.campass.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ViewController {
	
	@GetMapping("/product/product")
	public void main() {
	}
	
	@GetMapping("/product/pcart")
	public void listCart() {
	}
	
	@GetMapping("/product/order")
	public void order() {
		
	}
}	