package com.campass.demo.dto;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access=AccessLevel.PRIVATE)
public class ProductDto {
	@Data
	public static class ReadCategoryList{
		private Integer pCateCode;
		private String pCateName;
	}
	
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
	@AllArgsConstructor
	public static class ProductPaging {
		private Integer pageno;
		private Integer pagesize;
		private Integer totalcount;
		private Collection<ForProductList> productList;
	}
	
	// 카테고리
	@Data
	@AllArgsConstructor
	public static class Category{
		private String pCateCode;
		private String pCateName;
	}
	
	// 용품 상세페이지	
	@Data
	@Builder
	public static class PdtDetail {
		private Integer pCode;
		private String pName;
		private String pMainImg;
		private String pContentImg;
		private String pBrand;
		private Integer pStarAvg;
		private Integer pPrice;
	}
	
	@Data
	public static class ProductInput {
		private String pName;
		private MultipartFile pMainImg;
	}
	
	@Data
	public static class InputList {
		private List<ProductInput> list;
		
	}
	
	@Data
	public static class ReadReviewList{
		//private Integer pReviewNo;
		private Integer pStar;
		private String pReviewContent;
		private String username;
		@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
		private LocalDate pReviewDate;
	}
}
