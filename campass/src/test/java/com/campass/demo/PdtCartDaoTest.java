package com.campass.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.campass.demo.dao.PdtCartDao;
import com.campass.demo.entity.PdtCart;

@SpringBootTest
public class PdtCartDaoTest {

	@Autowired
	PdtCartDao cartDao;
	
	//@Test
	public void diTest() {
		assertNotNull(cartDao);
	}
	
	// 장바구니 추가 
	//@Test
	public void pAddCartTest() {
		PdtCart pdtCart = PdtCart.builder().pdtCartAmo(1).bId("spring").pCode(100).build();
		
		assertEquals(1, cartDao.pAddCart(pdtCart));
	}
	
	// 장바구니 삭제 
	//@Test
	public void cartAllDeleteTest() {
		// 없어서 삭제 실패
		assertEquals(0, cartDao.cartAllDelete(5));
		// 삭제 성공
		assertEquals(1, cartDao.cartAllDelete(1));
	}
	
	// 장바구니 리스트
	@Test
	public void listTest() {
		System.out.println(cartDao.listCart("spring"));
		assertEquals("스텔라릿지", cartDao.listCart("spring").get(0).getPName());
	}
	
	
}
