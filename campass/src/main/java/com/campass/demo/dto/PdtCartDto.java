package com.campass.demo.dto;

import java.util.List;

import com.campass.demo.entity.PdtCart;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PdtCartDto {

	@Data
	@Builder
	public static class pAddCart{
		private Integer pdtCartAmo;	//장바구니수량
		private String bId;			//회원코드
		private Integer pCode;		//상품코드
		
		public PdtCart toEntity() {
			return PdtCart.builder().pdtCartAmo(pdtCartAmo).bId(bId).pCode(pCode).build();
		}
	}
	
	@Data
	@ToString
	public static class Read{
		private Integer pdtCartNo;  //장바구니번호
		private String bId; 		
			
		private Integer pCode; 		
		private Integer pdtCartAmo; 
		private String pName;		//상품이름
		private Integer pPrice;		//상품가격
		private String pBrand;	//상품 브랜드
		
		//public void initTotalPrice() {
		//this.totalPrice = this.pPrice*this.pdtCartAmo;
		//}
	}
	
	@Builder
	@Data
	public static class cartCountUpdate {
		private Integer pdtCartNo;
		private Boolean countVal;
		private Integer pCode;
		private String bId;
	}
	
	@Data
	public static class delete{
		private List<Integer> pdtCartNo;
	}
	
	@Data
	@Builder
	public static class result {
		private List<PdtCartDto.Read> list;
		private Integer total;
	}

}
