package com.campass.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.campass.demo.dto.PdtReviewDto;
import com.campass.demo.service.PdtReviewService;

@Controller
public class PdtReviewController {
	@Autowired
	PdtReviewService service;
	
//	@GetMapping(value="/product/detail", produces=MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<PdtReviewDto> read(String bId){
//		return ResponseEntity.ok(new PdtReviewDto("상세페이지의 용품 리뷰 출력" ,service.reviewList(bId)));
//	}
//	
//	@DeleteMapping(value="", produces=MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<PdtReviewDto> delete(Integer pReviewNo){
//		return ResponseEntity.ok(new PdtReviewDto(service.delete(pReviewNos), null));
//		
//	}
}


