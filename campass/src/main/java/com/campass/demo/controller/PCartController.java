package com.campass.demo.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.campass.demo.dto.PdtCartDto;
import com.campass.demo.service.PCartService;

@Controller
public class PCartController {
	
	@Autowired 	
	private PCartService service;
	
	// 장바구니 추가 
	@PostMapping("/product/pcart/add")
	@ResponseBody
	public String addCartPOST(PdtCartDto.pAddCart cart, HttpServletRequest request) throws Exception {
		// 카트 등록
		String result = service.pAddCart(cart);
		
		return result + "";
	}

	
	//	장바구니 리스트
	   @GetMapping(value = "/product/pcartt", produces = MediaType.APPLICATION_JSON_VALUE)
	   public ResponseEntity<List<PdtCartDto.Read>> listCart(String bId){ // 로그인 아이디로 대체
		   return ResponseEntity.ok(service.listCart(bId));
	   }
	
//	@GetMapping(value="/product/pcart/")
//	public List<PdtCartDto.Read> listCart(String bId, Model model) throws Exception {
//		model.addAttribute("cartInfo", service.listCart(bId));
//		return "/product/pcart";
//}

	
	
}
