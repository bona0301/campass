package com.campass.demo.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.campass.demo.dto.ProductDto;
import com.campass.demo.dto.ResponseDto;
import com.campass.demo.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService service;
	
	// 카테고리 리스트
	@GetMapping(value = "/product/cateList", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto> readCategory(){
		return ResponseEntity.ok(new ResponseDto("카테고리 리스트 출력", service.categoryRead()));
	}
	
	// 글목록 출력
	@GetMapping(value = "/product/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductDto.ProductPaging> findAll(@RequestParam(defaultValue = "1") Integer pageno, Integer pCode) {
		System.out.println("==========================");
		System.out.println(service.findAll(pageno, null));
		System.out.println("==========================");
		return ResponseEntity.ok(service.findAll(pageno, null));
	}
	
	// 이미지 출력
	private MediaType getMediaType(String pMainImgName) {
		int position = pMainImgName.lastIndexOf(".");
		String ext = pMainImgName.substring(position+1).toUpperCase();
		if(ext.equals("JPG"))
			return MediaType.IMAGE_JPEG;
		else if(ext.equals("PNG"))
			return MediaType.IMAGE_PNG;
		else 
			return MediaType.IMAGE_GIF;
	}
	
	@GetMapping(path="/productImg/{pMainImgName}", produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> showProduct(@PathVariable String pMainImgName) {
		File file = new File("c:/productImg", pMainImgName);
		if(file.exists()==false)
			return null;
	
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(getMediaType(pMainImgName));
		
		headers.add("Content-Disposition", "inline;filename="+pMainImgName);
		try {
			return ResponseEntity.ok().headers(headers)
					.body(Files.readAllBytes(file.toPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping(value="/product/detail", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductDto.PdtDetail> productDetail(Integer pCode){
		return ResponseEntity.ok(service.detail(pCode));

	}
	
	@GetMapping(value="/product/detail/review", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto> read(String username){
		return ResponseEntity.ok(new ResponseDto("상세페이지의 용품 리뷰 출력" ,service.reviewList(username)));
	}
	
}


