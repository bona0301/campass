package com.campass.demo.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PdtCartDto {

	@Data
	public static class Read{
		private Integer pdtCartNo;  //장바구니코드
		private String bId; 		//회원코드
			
		private Integer pCode; 		//상품코드
		private String pName;		//상품이름
		private Integer pPrice;		//상품가격
		
		private Integer totalPrice;	//총가격
}
}
