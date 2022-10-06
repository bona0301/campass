package com.campass.demo.dto;

import java.util.Collection;
import java.util.List;


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
		private String pdtImg;
		private String pName;
		private Integer pPrice;
		private String pCateCode;  
	}
	
	@Data
	@AllArgsConstructor
	public static class ProductPage {
		private Integer pageno;
		private Integer pagesize;
		private Integer totalcount;
		private Collection<ForProductList> reviewList;
	}
	
	@Data
	@AllArgsConstructor
	public class CategoryDto{
		private String pCateCode;
		private String pCateName;
		private List<ProductDto> cateList;
	}
	
	// 용품 상세페이지	
	@Data
	public static class PdtDetail {
		private Integer pCode;
		private String pdtImg;
		private String pName;
		private String pContent; // 상세이미지
		private String pBrand;
		private Integer pStarAvg;
		private Integer pPrice;
		private String pCateCode;
		private String pCateName;
	}
	
	// 리뷰는 pdtReviewDto
}
