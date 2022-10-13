package com.campass.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.campass.demo.dto.ProductDto;
import com.campass.demo.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService service;
	
	@GetMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductDto.ForProductList>> list(Integer pCode) {
		return ResponseEntity.ok(service.list(pCode));
	}
}


