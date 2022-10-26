package com.campass.demo.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.campass.demo.dto.ProductDto;

@Mapper
public interface ProductDao {
	// 카테고리 리스트 읽어오기
	public List<ProductDto.ReadCategoryList> ReadCateList();
	
	// 목록페이지
	public List<ProductDto.ForProductList> productList();
	
	// 개수
	public Integer countProduct(Integer pCode);
	
	// 이미지
	public List<ProductDto.ProductInput> imgList();
	 
	// 페이징
	public List<ProductDto.ForProductList> findAll(Map map);                                          
	
	// 상세페이지 
	public Optional<ProductDto.PdtDetail> productDetail(Integer pCode);
	
	// 한줄평 목록
	public List<ProductDto.ReadReviewList> reviewList(String username);
				
}
