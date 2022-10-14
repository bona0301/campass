package com.campass.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.campass.demo.dto.POrderDto;
import com.campass.demo.dto.pOrderPageDto;

@Mapper
public interface POrderDao {

	//주문상품 정보
	public List<POrderDto.Read> getGoodsInfo(Integer pCode);
	
}
