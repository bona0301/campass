package com.campass.demo.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class POrder {
	private Integer pOrderNo;		// 주문결제
	private LocalDate pOrderDate;
	private Integer pOrderPrice;
	
	private Integer pOdtNo;			//구매내역 
	private Integer pOdtPrice;
	private Integer pOrderAmo;
	private String pOrderStatus;
}
