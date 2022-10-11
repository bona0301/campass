package com.campass.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campass.demo.dao.POrderDao;
import com.campass.demo.dto.POrderDto;
import com.campass.demo.dto.POrderDto.Read;

@Service
public class pOrderService {
	
	@Autowired
	POrderDao orderdao;

	// 주문상품 정보 
	public List<POrderDto.Read> goodsInfo(List<POrderDto.Read> orders){
		
		List<POrderDto.Read> cart = new ArrayList<POrderDto.Read>();		
		
		for(Read dto : orders) {
			
			POrderDto.Read goodsInfo = (Read) orderdao.getGoodsInfo(dto.getPCode());			

			goodsInfo.setPOrderAmo(dto.getPOrderAmo());	
			
			goodsInfo.initTotalPrice();			
			
			cart.add(goodsInfo);			
		}		
		
		return cart;
	}
}
