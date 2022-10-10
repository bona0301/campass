package com.campass.demo.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.campass.demo.dto.PdtReviewDto;
import com.campass.demo.entity.PdtReview;

@Mapper
public interface PdtReviewDao {
	// 한줄평 목록
	public List<PdtReviewDto.ReadReviewList> reviewList(String bId);
			
	// 댓글 등록
	public Integer saveReview(PdtReview pdtReview);
	
	// 글쓴이 확인
	public Optional<String> findById(Integer pReviewNo);
	
	// 댓글번호로 댓글 삭제
	public Integer deletePdtReview(Integer pReveiwNo);
	

}
