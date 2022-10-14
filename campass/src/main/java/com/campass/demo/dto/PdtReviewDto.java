package com.campass.demo.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

public class PdtReviewDto {
	@Data
	public static class Read{
		private Integer pReviewNo;
		private Integer pStar;
		private String pReviewContent;
		private String bId;
		@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
		private LocalDate pReviewDate;
	}
}
