package com.campass.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.campass.demo.dto.ProductDto;
import com.campass.demo.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService service;
	
	// 글목록 출력
	@GetMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductDto.ProductPaging> findAll(@RequestParam(defaultValue = "1") Integer pageno, Integer pCode) {
		System.out.println("==========================");
		System.out.println(service.findAll(pageno, null));
		System.out.println("==========================");
		return ResponseEntity.ok(service.findAll(pageno, null));
	}
	
	


}


