package com.campass.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.campass.demo.dto.PdtReviewDto;
import com.campass.demo.entity.PdtReview;

@Mapper
public interface PdtReviewDao {
	// 한줄평 목록
	public List<PdtReviewDto> ReviewList();
	// 저장
	public Integer saveReview(PdtReview pdtReview);
		
	// 글 변경, 삭제 전에 글쓴이를 확인 -> 글쓴이가 없다면 글이 존재하지 않는다
//	public Optional<String> findWriterById(Integer bno);
	
	// 한줄평 삭제
	public Integer deleteReview(Integer bno);
	
	// 한줄평 삭제 
	// public Boolean deleteReview2(Map<String, Object> dataMap);
}
