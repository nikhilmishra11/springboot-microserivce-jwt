package com.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentRequestDTO {

	private String cardNumber;
	private double amount;
}
