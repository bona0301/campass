package com.campass.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PdtCart {
	private Integer pdtCartNo;
	private Integer pdtCartAmo;
	private String username;
	private Integer pCode;

}
