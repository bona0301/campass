package com.campass.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.campass.demo.dto.ProductDto;

@Controller
public class UploadController {
	@GetMapping("/upload")
	public ModelAndView test3() {
		return new ModelAndView("/upload");
	}
	
	@PostMapping("/upload")
	public ModelAndView test3(ProductDto.InputList dto) {
		dto.getList().forEach(a->System.out.println(a.getPMainImg().getOriginalFilename()));
		return null;
	}
}
