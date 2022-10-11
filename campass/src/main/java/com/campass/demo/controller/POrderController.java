package com.campass.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.campass.demo.dto.pOrderPageDto;
import com.campass.demo.service.pOrderService;

@Controller
public class POrderController {
	
	@Autowired
	private pOrderService service;
	//멤버서비스 의존성주입 필요 
	
	@GetMapping("/order/{bId}")
	public String orderPgaeGET(@PathVariable("bId") String bId, pOrderPageDto orderDto, Model model) {
		
		model.addAttribute("orderList", service.goodsInfo(orderDto.getOrders()));
		//model.addAttribute("memberInfo", memberService.getMemberInfo(memberId));
		
		return "/order";
		
	}
}
