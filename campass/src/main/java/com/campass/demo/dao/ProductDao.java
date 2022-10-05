package com.campass.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.campass.demo.dto.ProductDto;
import com.campass.demo.entity.AttachImage;
import com.campass.demo.entity.Product;


@Mapper
public interface ProductDao {
	// 목록페이지
	public List<ProductDto> productList(Map<String, Object> map);
	
	// 개수
	public Integer count(Integer pCode);
	
	// 카테고리 리스트 
	public List<Product> cateList();	
	
	// 국내 카테고리 리스트 
	public List<Product> getCateCode1();
	
	// 외국 카테고리 리스트
	public List<Product> getCateCode2();
	 
	// 페이징
	//public List<ForList> findAll(Map<String, Object> map);
	 
	// 상세페이지 
	public ProductDto detailProduct(int product_id);
	// public Optional<ProductDto.Detail> findById(Integer bno);
	
	// 이미지 데이터 반환 
	public List<AttachImage> getAttachList(int bookId);
}
