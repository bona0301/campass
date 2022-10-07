package com.campass.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campass.demo.dao.PdtCartDao;
import com.campass.demo.dto.PdtCartDto;
import com.campass.demo.dto.PdtCartDto.Read;
import com.campass.demo.entity.PdtCart;

@Service
public class PCartService {

	@Autowired
	PdtCartDao cartDao;
	
	// 장바구니 추가
		public String pAddCart(PdtCartDto.pAddCart dto) {
			
		PdtCart pdtcart = dto.toEntity();
		cartDao.pAddCart(pdtcart);
		return null;
		
	}
		
	// 장바구니 정보 리스트 
		public List<PdtCartDto.Read> listCart(String bId) {
			
			List<PdtCartDto.Read> cart = cartDao.listCart(bId);
			
			for(Read dto : cart) {
				dto.initTotalPrice();
			}
			return cart;
		}

}
