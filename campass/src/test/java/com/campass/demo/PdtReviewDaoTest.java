package com.campass.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.campass.demo.dao.PdtReviewDao;
import com.campass.demo.entity.PdtReview;

@SpringBootTest
public class PdtReviewDaoTest {
	@Autowired
	PdtReviewDao dao;
	
	//@Test
	public void diTest() {
		assertNotNull(dao);
	}
	
	// pStar, pReviewContent, username,pOdtNo, pOrderNo, pCode, shipName
	@Transactional
	@Test
	public void SaveTest() {
		PdtReview pdtReview = PdtReview.builder().pStar(3).pReviewContent("JMTGR").username("spring").pOdtNo(333).pOrderNo(122).pCode(43).shipName("인천일보아카데미").build();
		assertEquals(1, dao.saveReview(pdtReview));
	}
	
	//@Test
	public void findById() {
		assertEquals("spring", dao.findById(1).get());
	}
}
