package com.demo.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderResponseDTO {
	private long orderId;
	private long productId;
	private LocalDateTime date;
	private String status;
}
