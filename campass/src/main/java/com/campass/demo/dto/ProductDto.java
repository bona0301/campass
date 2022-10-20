package com.campass.demo.dto;

import java.util.Collection;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access=AccessLevel.PRIVATE)
public class ProductDto {
	// 목록
	@Data
	public static class ForProductList {
		private Integer pCode;
		private String pName;
		private String pMainImg;
		private Integer pPrice;
		private String pCateCode;  
	}
	
	// 목록 페이징
	@Data
	public static class PdtDetail {
		private Integer pCode;
		// 이미지
		private String pName;

		private String pMainImg;
		private String pContentImg;

		private String pBrand;
		private Integer pStarAvg;
		private Integer pPrice;
		private String pCateCode;
		private String pCateName;
	}
	
	// 용품 상세페이지	
	@Data
	@Builder
	public static class PdtDetail {
		private Integer pCode;
		private String pName;
		private String pContentImg;
		private String pBrand;
		private Integer pStarAvg;
		private Integer pPrice;
		private String pCateCode;
	}
	
	// 리뷰는 pdtReviewDto
}
