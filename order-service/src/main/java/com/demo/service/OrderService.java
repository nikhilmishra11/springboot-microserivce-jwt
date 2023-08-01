package com.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.demo.dto.OrderRequestDTO;
import com.demo.dto.OrderResponseDTO;
import com.demo.entity.Order;
import com.demo.repo.OrderRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final OrderRepo orderRepo;
	public OrderResponseDTO processOrder(OrderRequestDTO dto) {
		Order order = Order.builder()
		.id(1234)
		.createdDateTime(LocalDateTime.now())
		.status("Pending")
		.productId(dto.getProductId())
		.build();
		orderRepo.save(order);
		return OrderResponseDTO.builder()
				.orderId(new Random().nextLong())
				.status("Pending")
				.productId(dto.getProductId())
				.date(LocalDateTime.now())
				.build();
	}

	public String getStatus(Long orderId) {
		return orderRepo.findById(orderId)
		.map(Order::getStatus)
		.orElseThrow();
	}

	public void updateStatus() {
		List<Order> orders = orderRepo.findByStatus("Pending");
		if(!CollectionUtils.isEmpty(orders)) {
			LocalDateTime fourHoursAgo = LocalDateTime.now().minusHours(6);
			List<Order> updateOrders = orders.stream()
			.filter(order -> order.getCreatedDateTime().isBefore(fourHoursAgo))
			.map(order -> {
				order.setStatus("Completed");
				return order;
			}).collect(Collectors.toList());
			if(!CollectionUtils.isEmpty(updateOrders)) {
				orderRepo.saveAll(updateOrders);
			}
		}
	}

}
