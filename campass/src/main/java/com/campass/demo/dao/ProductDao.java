package com.campass.demo.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.campass.demo.dto.ProductDto;
import com.campass.demo.dto.ProductDto.ForProductList;
import com.campass.demo.entity.AttachImage;

@Mapper
public interface ProductDao {
	// 목록페이지
	public List<ProductDto> productList();
	
	// 개수
	public Integer countProduct(Integer pCode);
	
	// 카테고리 리스트 
	public List<ProductDto> cateList();	
	 
	// 페이징
	public List<ForProductList> findAll(Map<String, Object> map);                                          
	 
	///////////////////////////////////////////////////////////////
	
	// 상세페이지 
	public Optional<ProductDto.PdtDetail> findById(Integer bno);
	
	// 이미지 데이터 반환 
	public List<AttachImage> getAttachList(int bookId);
	
	// 구매하기
	public Integer buyProduct(Integer pCode);
}
