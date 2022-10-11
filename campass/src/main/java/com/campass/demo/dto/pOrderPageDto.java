package com.campass.demo.dto;

import java.util.List;

import lombok.Data;

@Data
public class pOrderPageDto {

	private List<POrderDto.Read> orders;
}
