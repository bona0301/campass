package com.campass.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campass.demo.dao.PdtReviewDao;
import com.campass.demo.dao.ProductDao;
import com.campass.demo.dto.PdtReviewDto;
import com.campass.demo.entity.PdtReview;
import com.campass.demo.entity.Product;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;
	@Autowired
	private PdtReviewDao pdtReviewDao;
	
	
}
