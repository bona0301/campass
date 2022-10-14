package com.campass.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.campass.demo.dao.PdtReviewDao;
import com.campass.demo.entity.PdtReview;

@SpringBootTest
public class PdtReviewDaoTest {
	@Autowired
	PdtReviewDao dao;
	
	@Test
	public void diTest() {
		assertNotNull(dao);
	}
	
	@Test
	public void listTest() {
		assertNotNull(dao.reviewList("spring"));
	}


	@Test
	public void SaveTest() {
		PdtReview pdtReview = PdtReview.builder().pStar(5).pOrderNo(1).pOdtNo(2).pReviewContent("JMTGR").bId("spring").pCode(1).build();

		assertEquals(1, dao.saveReview(pdtReview));
	}

	@Test
	public void findById() {
		assertEquals("spring", dao.findById(1).get());
	}

	@Test
	public void deleteTest() {
		assertEquals(1, dao.deletePdtReview(1));
	}
}