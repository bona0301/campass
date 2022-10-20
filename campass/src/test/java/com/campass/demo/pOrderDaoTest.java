package com.campass.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.campass.demo.dao.POrderDao;
import com.campass.demo.entity.PdtOrder;

@SpringBootTest
public class pOrderDaoTest {

	@Autowired
	POrderDao orderDao;
	
	//@Test
	public void diTest() {
		assertNotNull(orderDao);
	}
	
	//주문처리 
	@Test
	public void orderSaveTest() {
		
		PdtOrder pdtOrder = PdtOrder.builder().bId("spring").shipName("주문자명").shipAddr("인천시 미추홀구 블라블라").pOrderStatus(OrderStatus.주문완료).build();
		assertEquals(1, orderDao.orderSave(pdtOrder));
	
	}
	
	//주문상태 확인 다시
	//@Test
	public void pOrderStatusTest() {
		//assertEquals(OrderStatus.주문완료, orderDao.pOrderStatus(2));
	}
	
	//주문취소 
	//@Test
	public void deleteOrderTest() {
		//assertEquals(1, orderDao.deleteOrder(2));
	}
}
