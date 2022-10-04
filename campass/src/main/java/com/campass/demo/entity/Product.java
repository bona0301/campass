package com.campass.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Product {
	private String pCode;
	private String pName;
	private String pContent;
	private String pBrand;
	private Integer pStarAvg;
	private Integer pPrice;
}
 
