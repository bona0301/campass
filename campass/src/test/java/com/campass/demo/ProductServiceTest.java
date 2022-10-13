package com.campass.demo;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.campass.demo.service.ProductService;

@SpringBootTest
public class ProductServiceTest {
	@Autowired
	private ProductService service;
	
	//@Test
	public void listTest() {
		assertNotEquals(0, service.list(1));
	}
	
	@Test
	public void readTest() {
		assertNotEquals(0, service.detail(1));
	}
}


