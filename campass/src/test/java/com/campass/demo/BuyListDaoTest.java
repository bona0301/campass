package com.campass.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.campass.demo.dao.BuyListDao;

@SpringBootTest
public class BuyListDaoTest {
	@Autowired
	BuyListDao dao;
	
	@Test
	public void initTest() {
		assertNotNull(dao);
	}
}
