package com.campass.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campass.demo.dao.PdtReviewDao;
import com.campass.demo.dto.PdtReviewDto;
import com.campass.demo.entity.PdtReview;

@Service
public class PdtReviewService {
	@Autowired
	PdtReviewDao dao;
	
	public List<PdtReviewDto.ReadReviewList> reviewList(String bId){
		return dao.reviewList(bId);
	}
	
	public PdtReview saveReview(PdtReviewDto.SaveReview dto) {
		PdtReview pdtReview = dto.toEntity();
	
		pdtReview.addWriter("spring",111);
		dao.saveReview(pdtReview);
		
		return pdtReview;
	}
	
	public String delete(Integer pReviewNo) {
		dao.deletePdtReview(pReviewNo);
		
		return "리뷰가 삭제되었습니다";
	}
	
//	public List<PdtReviewDto.ReadReviewList> write(PdtReviewDto.SaveReview dto, String loginId){
//		dao.saveReview(dto.toEntity().addWriter(loginId));
//		return dao.findById(dto.getPOdtNo());
//	}
	
//	@Transactional
//	public List<PdtReviewDto.ReadReviewList> delete (PdtReviewDto.DeleteReview dto, String loginId){
//		String bId = dao.findById(dto.getPReviewNo()).orElseThrow(PdtReviewNotFoundException::new);
//		if(!bId.equals(loginId))
//			throw new JobFailException("삭제할 수 없습니다");
//		dao.deletePdtReview(dto.getPCode());
//		return dao.findByPCode(d)
//	}

}
