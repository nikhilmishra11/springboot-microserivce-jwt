package com.demo.service;

import org.springframework.stereotype.Service;

import com.demo.dto.Product;

@Service
public class ProductService {

	public Product findProductById(long productId) {
		return Product.builder()
				.id(productId)
				.productName("Test Product")
				.build();
	}

}
