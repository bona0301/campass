package com.campass.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.campass.demo.dto.PdtCartDto;
import com.campass.demo.dto.ResponseDto;
import com.campass.demo.service.PCartService;

@Controller
public class PCartController {
	@Autowired
	PCartService service;
	
	// 장바구니 추가 
	@PostMapping(value="/pcart/add")		// produces = MediaType.APPLICATION_JSON_VALUE
	public ResponseEntity<ResponseDto> pAddCart (PdtCartDto.pAddCart dto){
		return ResponseEntity.ok(new ResponseDto(service.pAddCart(dto),service.listCart(dto.getBId())));
	}
	
	// 장바구니 리스트
	@GetMapping(value="/pcart/list")
	public ResponseEntity<ResponseDto> listcart(String bId){//로그인 아이디로 대체
		return ResponseEntity.ok(new ResponseDto("장바구니 리스트 출력", service.listCart(bId)));
	}
	/* 페이지 이동요청 (jsp -> ${cartInfo} )
	@GetMapping("/pcart/{memberId}")
	public String cartPageGET(@PathVariable("bId") String bId, Model model) {
		model.addAttribute("cartInfo", service.getCartList(bId));
		return "/cart";} */
}
