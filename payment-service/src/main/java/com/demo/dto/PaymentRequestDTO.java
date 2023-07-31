package com.demo.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PaymentRequestDTO {

	@Length(min = 16, max = 16)
	@NotBlank(message = "Card Number must be provided")
	@Pattern(regexp = "^\\d+$", message = "Card Number muust be 16 digit")
	private String cardNumber;

	@DecimalMin("0.0")
	private double amount;
}
