package com.campass.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;


import com.campass.demo.service.ProductService;

@Validated
@Controller
public class ProductController {
	@Autowired
	private ProductService service;
	
	// 상품목록
	
	
	// 상품상세
}
