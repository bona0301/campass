package com.campass.demo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.campass.demo.entity.PdtReview;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access=AccessLevel.PRIVATE)
public class PdtReviewDto {
	@Data
	public static class SaveReview {
		@NotEmpty
		private Integer pStar;
		@NotEmpty
		private String pReviewContent;

		public PdtReview toEntity() {
			return PdtReview.builder().pStar(pStar).pReviewContent(pReviewContent).build();
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