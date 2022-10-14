package com.campass.demo.dto;

import com.campass.demo.entity.PdtCart;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PdtCartDto {

	@Data
	@ToString
	@Builder
	public static class pAddCart{
		private Integer pdtCartAmo;	//장바구니수량
		private String bId;			//회원코드
		private Integer pCode;		//상품코드
		
		public PdtCart toEntity() {
			return PdtCart.builder().pdtCartAmo(pdtCartAmo).bId(bId).pCode(pCode).build();
		}
	}
	
	@Getter
	@Data
	@ToString
	public static class Read{
		private Integer pdtCartNo;  //장바구니번호
		private String bId; 		
			
		private Integer pCode; 		
		private Integer pdtCartAmo; 
		private String pName;		//상품이름
		private Integer pPrice;		//상품가격
		private Integer totalPrice; //총가격
		
		public void initTotalPrice() {
		this.totalPrice = this.pPrice*this.pdtCartAmo;
		}
			
	}

}
