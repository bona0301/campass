package com.campass.demo.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class pOrderPageDto {

	@Data
	@ToString
	public static class read{
		/* 뷰로부터 전달받을 값 */
	    private int pCode;
	    private int pdtCartAmo;
	    
		/* DB로부터 꺼내올 값 */
	    private String pName;
	    private int pPrice;
	    
	    private int totalPrice;
	    
	}
	
}
