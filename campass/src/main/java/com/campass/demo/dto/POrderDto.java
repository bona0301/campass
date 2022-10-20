package com.campass.demo.dto;

import java.util.List;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class POrderDto {	
	@Data
	@ToString
	@Builder
	public static class orderItem{
		// 뷰로부터 전달받을 값 
	    private int pCode;
	    private int pdtCartAmo;
	    
		// DB로부터 꺼내올 값 
	    private String pName;
	    private int pPrice;
	    
		// 만들어 낼 값 
	    private int totalPrice;

	    public void iniTotal() {
			this.totalPrice = this.pPrice*this.pdtCartAmo;
		}
	}
	
	@Data
	@ToString
	public static class orderPage{
		private List<orderItem> orders;
	}
}

