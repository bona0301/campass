package com.campass.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.campass.demo.dto.PdtReviewDto;
import com.campass.demo.dto.ResponseDto;
import com.campass.demo.service.PdtReviewService;

@Controller
public class PdtReviewController {
	@Autowired
	PdtReviewService service;
	
	@PostMapping(value="/product/detail/review/save", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto> save(PdtReviewDto.SaveReview dto) {
		return ResponseEntity.ok(new ResponseDto("한줄평 작성이 완료되었습니다", service.saveReview(dto)));
	}
	

	@GetMapping(value="/product/detail/review", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto> read(String bId){
		return ResponseEntity.ok(new ResponseDto("상세페이지의 용품 리뷰 출력" ,service.reviewList(bId)));
	}
	
	@DeleteMapping(value="/product/detail/review/delete", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto> delete(Integer pReviewNo){
		return ResponseEntity.ok(new ResponseDto(service.delete(pReviewNo), null));
		
	}
}


