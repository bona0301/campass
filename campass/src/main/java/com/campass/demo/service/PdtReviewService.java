package com.campass.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campass.demo.dao.PdtReviewDao;
import com.campass.demo.dto.PdtReviewDto;

@Service
public class PdtReviewService {
	@Autowired
	PdtReviewDao dao;
	
	public List<PdtReviewDto.ReadReviewList> reviewList(String bId){
		return dao.reviewList(bId);
	}
	
//	public PdtReview saveReview(PdtReviewDto.SaveReview dto) {
//		PdtReview pdtReview = dto.toEntity();
		
//		PdtReview pdtReview;
//		pdtReview.addWriter("spring",111);
//		dao.saveReview(pdtReview);
//		
//		return pdtReview;
//	}
	
	public String delete(Integer pReviewNo) {
		dao.deletePdtReview(pReviewNo);
		
		return "리뷰가 삭제되었습니다";
	}

}
