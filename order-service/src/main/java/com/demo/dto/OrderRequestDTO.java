package com.demo.dto;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class OrderRequestDTO {

	private long productId;
	private String cardNumber;
	private double amount;
}
