package com.campass.demo.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class POrderDto {

@Data
	public static class Read{
	
	// 뷰로부터 전달받을 값
    private int pCode;
    private int pOrderAmo;
    
	// DB로부터 꺼내올 
    private String pName;
    private int pPrice;
    
	//만들어 낼 값
    private int totalPrice;

    //총금액 만드는 변수 세팅 	
    public void initTotalPrice() {
		this.totalPrice = this.pOrderAmo*this.pPrice;
	}
	}

}
