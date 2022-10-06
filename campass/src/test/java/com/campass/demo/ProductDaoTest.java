package com.campass.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.campass.demo.dao.ProductDao;

@SpringBootTest
public class ProductDaoTest {
	@Autowired
	ProductDao dao;
	
	//@Test
	public void initTest() {
		assertNotNull(dao);
	}
	
	//@Test
	public void countTest() {
		assertEquals(50, dao.countProduct(null));
	}
	
//	@Test
//	public void cateTest() {
//		System.out.println(dao);
//	}
	
//	@Test
//	public void findAllTest() {
//		// 전체글에서 첫번째 페이지 : 글의 개수 10개
//		Map<String, Object> map = new HashMap<>();
//		map.put("start", 1);
//		map.put("end", 5);
//		assertEquals(5, dao.findAll(map).size());
//	}
	
	@Test
	public void findByIdtest() {
		Assertions.assertThrows(NoSuchElementException.class, 
				()->dao.findById(1).get());
	}
}
