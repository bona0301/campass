package com.campass.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.campass.demo.dao.ProductDao;
import com.campass.demo.dto.ProductDto;
import com.campass.demo.dto.ProductDto.ProductPaging;


@Service
public class ProductService {
	@Autowired
	private ProductDao dao;
	@Value("${campass.pagesize}")
	private Integer pagesize;
	
	// 용품 리스트 출력
	public List<ProductDto.ForProductList> list(Integer pCode){
		return dao.productList(pCode);
		
	}
	
	// 용품 페이징
	public ProductDto.ProductPaging list(Integer pageno, Integer pCode) {
		Integer totalcount = dao.countProduct(pCode);
		Integer start = (pageno-1) * pagesize + 1;
		Integer end = start * pagesize - 1;
		
		Map<String,Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		map.put("pCode", pCode);
		return new ProductPaging(pageno,pagesize,totalcount,dao.findAll(map));
	}
	
	// 용품 상세페이지 출력
	public ProductDto.PdtDetail detail(Integer pCode){
		return dao.productDetail(pCode).get();
	}
}
