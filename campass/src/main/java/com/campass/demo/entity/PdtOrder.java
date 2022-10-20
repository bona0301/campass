	package com.campass.demo.entity;

import java.time.LocalDate;

import com.campass.demo.OrderStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class PdtOrder {
	private Integer pOrderNo;		 	//주문번호	
	private String shipName;			//배송지명 
	private String shipAddr;			//배송주소
	private LocalDate pOrderDate;		//주문날짜
	private OrderStatus pOrderStatus;	//주문상태

	private String bId;					//회원코드

}

