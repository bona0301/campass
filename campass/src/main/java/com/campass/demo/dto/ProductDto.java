package com.campass.demo.dto;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.campass.demo.entity.PdtReview;
import com.fasterxml.jackson.annotation.JsonFormat;

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
	
	/////////////////////////////////////////////////////
	
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
	
	@Data	
	public static class ReadReview {
		private Integer pReviewNo;
		private Integer pStar;
		private String pReviewContent;
		private String bId;
		@JsonFormat(pattern="yyyy-MM-dd")
		private LocalDate pReviewDate;
	}
	
	@Data
	@Builder
	public static class WriteReview {
		@NotEmpty
		private Integer pStar;
		@NotEmpty
		private String pReviewContent;
		@NotNull
		private Integer pCode;
		public PdtReview toEntity() {
			return PdtReview.builder().pReviewContent(pReviewContent).pCode(pCode).build();
		}
	}
	
	
	@Data
	public static class DeleteReview {
		@NotNull
		private Integer pReviewNo;
		@NotNull
		private Integer pCode;
	}
	
}
