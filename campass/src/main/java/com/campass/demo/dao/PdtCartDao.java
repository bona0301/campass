package com.campass.demo.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.campass.demo.dto.PdtCartDto;
import com.campass.demo.entity.PdtCart;

@Mapper
public interface PdtCartDao {
	// 장바구니 추가 
	public Integer pAddCart(PdtCart pdtCart) throws Exception;	
	
	// 장바구니 비우기
	public int cartAllDelete(Integer pdtCartNo) throws Exception;

	// 수량 변경 
	public int pCartAmoUpdate(Integer pCode) throws Exception;
	
	// 장바구니 목록
	//public CartDto checkCart(CartDto cart);

	
	// 장바구니 리스트 
	public List<PdtCartDto.Read> listCart(String bId) throws Exception;
	


}
