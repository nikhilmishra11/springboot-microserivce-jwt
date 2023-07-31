package com.demo.service;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.demo.dto.OrderRequestDTO;
import com.demo.dto.OrderResponseDTO;

@Service
public class OrderService {

	public OrderResponseDTO processOrder(OrderRequestDTO dto) {
		return OrderResponseDTO.builder()
				.orderId(new Random().nextLong())
				.status("Pending")
				.productId(dto.getProductId())
				.date(LocalDateTime.now())
				.build();
	}

	public String getStatus(String orderId) {
		return "pending";
	}

}
