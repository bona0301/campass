package com.campass.demo.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import com.campass.demo.dto.ProductDto;

@Mapper
public interface ProductDao {
	// 목록페이지
	public List<ProductDto.ForProductList> productList(Integer pCode);

	// 개수
	public Integer countProduct(Integer pCode);
	 
	// 페이징
	public List<ProductDto.ForProductList> findAll(Map map);                                          
	
	// 상세페이지 
	public Optional<ProductDto.PdtDetail> productDetail(Integer pCode);
}