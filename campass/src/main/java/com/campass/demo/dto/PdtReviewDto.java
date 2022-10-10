package com.campass.demo.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.campass.demo.entity.PdtReview;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access=AccessLevel.PRIVATE)
public class PdtReviewDto {
	@Data
	public static class ReadReviewList{
		//private Integer pReviewNo;
		private Integer pStar;
		private String pReviewContent;
		private String bId;
		@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
		private LocalDate pReviewDate;
	}
	
	@Data
	public static class SaveReview {
		private Integer pStar;
		private String pReviewContent;
		
		public PdtReview toEntity() {
			return null;
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
