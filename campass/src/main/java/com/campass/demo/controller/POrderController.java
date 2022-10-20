package com.campass.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campass.demo.dto.POrderDto;
import com.campass.demo.service.pOrderService;


@RestController
public class POrderController {
	
	@Autowired
	private pOrderService service;
	//멤버서비스 의존성주입 필요 

	// 주문페이지 이동 
	@GetMapping("/order/{username}")
	public void orderPgaeGET(@PathVariable("bId") String bId, POrderDto.orderPage dto) {
	}
	
	// 장바구니 -> 주문 
	@PostMapping("/product/pcrt/order")
	public ResponseEntity<String> orderSave(POrderDto.orderItem dto) {
			return null;	
	}
	
	
	
}
