package com.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentResponseDTO {

	private String cardNumber;
	private double amount;
}
