package com.campass.demo.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.campass.demo.entity.PdtReview;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access=AccessLevel.PRIVATE)
public class PdtReviewDto {
	@Data
	public static class ForReviewList{
		private Integer pReviewNo;
		private Integer pStar;
		private String pReviewContent;
		private String bId;
		@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
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
