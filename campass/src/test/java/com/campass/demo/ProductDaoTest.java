package com.campass.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.campass.demo.dao.ProductDao;

@SpringBootTest
public class ProductDaoTest {
	@Autowired
	ProductDao dao;
	
	@Test
	public void diTest() {
		assertNotNull(dao);
	}
	
	@Test
	public void productList() {
		assertNotNull(dao.productList());
	}
	
	@Test
	public void countTest() {
		assertEquals(50, dao.countProduct(null));
	}
	
	@Test
	public void findAllTest() {
		// 페이징
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", 1);
		map.put("end", 16);
		assertEquals(16, dao.findAll(map).size());
	}
	
	@Test
	public void productDetailTest() {
		assertEquals(true, dao.productDetail(1).isPresent());
		assertEquals(true, dao.productDetail(51).isEmpty());
	}
	

	
}
