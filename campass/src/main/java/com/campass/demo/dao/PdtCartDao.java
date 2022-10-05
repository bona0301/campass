package com.campass.demo.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.campass.demo.dto.PdtCartDto;
import com.campass.demo.entity.PdtCart;

@Mapper
public interface PdtCartDao {
	// 아이디 체크 
	public String idCheck(String bId);
	
	// 장바구니 확인
	//public CartDto checkCart(CartDto cart);

	// 장바구니 추가 
	public int pAddCart(PdtCart pdcCart);	
	
	// 장바구니 리스트 
	public List<PdtCartDto.Read> listCart(String bId);
	
	// 수량 변경 
	public int pCartAmoUpdate(Integer pCode);

	// 장바구니 비우기 (장바구니코드?)
	public int cartAllDelete(String bId);

}
