package com.campass.demo.dao;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.campass.demo.entity.PdtReview;

@Mapper
public interface PdtReviewDao {
	// 댓글 등록
	public Integer saveReview(PdtReview pdtReview);
	
	// 용품글번호로 댓글 출력
	//public List<PdtReviewDto.ReadReviewList> findByPCode(Integer pCode);
	
	// 글쓴이 확인
	public Optional<String> findById(Integer pReviewNo);
	
	// 댓글번호로 댓글 삭제
	public Integer deletePdtReview(Integer pReveiwNo);
	

}
