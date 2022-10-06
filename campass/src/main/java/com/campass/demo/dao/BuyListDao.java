package com.campass.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BuyListDao {
	// 주문 상품 리스트 
	//public List<POrderDto> ForOrderList();
	
	// 주문 총개수
	public Integer countOrder(Integer pOrderNo);
	
}
