package com.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

	private long id;
	private String productName;
}
