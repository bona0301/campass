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
	@Test
	public void pAddCartTest() throws Exception {
		PdtCart pdtCart = PdtCart.builder().pdtCartAmo(1).username("spring").pCode(40).build();
		
		assertEquals(1, cartDao.pAddCart(pdtCart));
	}
	
	// 장바구니 삭제 
	//@Test
	public void cartDeleteTest() throws Exception {
		// 없어서 삭제 실패
		assertEquals(0, cartDao.cartDelete(10));
		// 삭제 성공
		assertEquals(1, cartDao.cartDelete(4));
	}

	
	// 장바구니 리스트
	//@Test
	public void listTest() throws Exception {
		System.out.println(cartDao.listCart("spring"));
		assertEquals("스텔라릿지", cartDao.listCart("spring").get(0).getPName());
	}
	
	// 수량변경
	//@Test
	public void cartAmoPlusCountTest() {
		cartDao.cartAmoPlusCount(1);
		assertEquals(1, cartDao.listCart("spring").get(0).getPdtCartNo());
	}
	//@Test
	public void cartAmoMinusCountTest() {
		cartDao.cartAmoMinusCount(1);
		assertEquals(1, cartDao.listCart("spring").get(0).getPdtCartNo());
	
	}
	
	
	
}
