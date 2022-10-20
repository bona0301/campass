package com.campass.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.campass.demo.entity.PdtOrder;

@Mapper
public interface POrderDao {
	// 주문취소?
	
	
	// 주문 상품정보(페이지)
	//public OrderProcutDto getProductInfo(int pOrderNo)
	
	// 주문상품 상세정보
	
	// 주문처리 
	public Integer orderSave(PdtOrder order);

	// 주문 내역 출력
	//public List<POrderDto.pOrderRead> pOrderRead(OrderReadDto dto);
	
	// 주문 상세 내역 출력
	//public List<POrderDto.pOrderRead> POrderListAll(Integer pOrderNo, String bId);
}
