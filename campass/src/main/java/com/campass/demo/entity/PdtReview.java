package com.campass.demo.entity;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class PdtReview {
	private Integer pReviewNo;
	private Integer pStar;
	private String pReviewContent;
	private String username;
	private LocalDate pReviewDate;
	private Integer pOdtNo;
	private Integer pOrderNo;
	private Integer pCode;
	private String shipName;

	public PdtReview addWriter(String loginId) {
		this.username = loginId;
		return this;
	}

}
