package com.campass.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campass.demo.dto.PdtCartDto;
import com.campass.demo.dto.ResponseDto;
import com.campass.demo.service.PCartService;

@RestController
public class PCartController {
	
	@Autowired 	
	private PCartService service;
	
	// 장바구니 추가 
	@PostMapping(value="/product/pcart/add")		// produces = MediaType.APPLICATION_JSON_VALUE
	public ResponseEntity<ResponseDto> pAddCart (PdtCartDto.pAddCart dto) throws Exception{
		return ResponseEntity.ok(new ResponseDto(service.pAddCart(dto),service.listCart(dto.getBId())));
	}  

	// 장바구니 리스트	
	@GetMapping(value = "/product/pcart/list")
	public ResponseEntity<ResponseDto> listCart(String bId) throws Exception{ // 로그인 아이디로 대체
		return ResponseEntity.ok(new ResponseDto("장바구니 리스트 출력", service.listCart(bId)));
	}
	
//	@GetMapping("/product/pcart/list")    //{bId}
//	public String cartPageGET(@PathVariable("bId") String bId, Model model) throws Exception {
//		
//		model.addAttribute("cartInfo", service.listCart(bId));
//		
//		return "/product/pcart";	
//	}
	
	
}
