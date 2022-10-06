package com.campass.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Product {
	private Integer pCode;
	private String pName;
	private String pdtImg;
	private String pContent;	// 상세이미지
	private String pBrand;
	private Integer pStarAvg;
	private Integer pPrice;
}
 
