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
	private Integer pOrderNo;
	private Integer pOdtNo;
	private Integer pStar;
	private String pReviewContent;
	private String bId;
	private LocalDate pReviewDate;
	private Integer pCode;
	
	public PdtReview addWriter(String loginId, Integer pOdtNo) {
		this.bId = loginId;
		this.pOdtNo = pOdtNo;
		return this;
	}
}