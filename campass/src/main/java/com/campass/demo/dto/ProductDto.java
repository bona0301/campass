package com.campass.demo.dto;

import java.time.LocalDate;
import java.util.Collection;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access=AccessLevel.PRIVATE)
public class ProductDto {
	// 목록
	@Data
	public static class ForProductList {
		private Integer pCode;
		// 이미지
		private String pName;
		private Integer pPrice;
		private String pCateCode;  
	}
	
	// 상세
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
	
	@Data
	@AllArgsConstructor
	public static class Page {
		private Integer pageno;
		private Integer pagesize;
		private Integer totalcount;
		private Collection<ForProductList> reviewList;
	}
	
	@Data	
	public static class review {
		private Integer pReviewNo;
		private Integer pStar;
		private String pReviewContent;
		private String bId;
		private LocalDate pReviewDate;
	}
	
	
}
