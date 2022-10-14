package com.campass.demo.entity;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class pOrderDetail {
	private Integer pOdtNo;			//주문상세번호
	private Integer pOrderAmo;		//주문수량	
	private Integer pPrice;			//용품금액
	
	private Integer pOrderNo;		//주문번호	
	private Integer pCode;			//상품코드 
}
