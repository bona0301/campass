package com.campass.demo.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PdtReview {
	private Integer pReviewNo;
	private Integer pStar;
	private String pReviewContent;
	private String bId;
	private LocalDate pReviewDate;
}
