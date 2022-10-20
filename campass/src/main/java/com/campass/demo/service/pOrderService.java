package com.campass.demo.service; 


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campass.demo.dao.POrderDao;
import com.campass.demo.dao.PdtCartDao;

@Service
public class pOrderService {
	
	@Autowired
	POrderDao orderdao;

	@Autowired
	PdtCartDao	cartdao;
	
	// 주문처리
	//public orderItem order(POrderDto.orderItem dto) {
		
		//orderdao.orderSave(order);
		//return dto;
//	}

	
	
}
