/**
 * 
 */
package com.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.OrderRequestDTO;
import com.demo.dto.OrderResponseDTO;
import com.demo.service.OrderService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/order")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;
	
	@PostMapping
	public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
		log.info("OrderController.createOrder(): request: {}", orderRequestDTO);
		return ResponseEntity.of(orderService.createOrder(orderRequestDTO));
	}
	
	@GetMapping("/{orderId}")
	public ResponseEntity<String> getStatus(@PathVariable String orderId) {
		log.info("OrderController.getStatus(): request: {}", orderId);
		return ResponseEntity.ok(orderService.getStatus(orderId));
	}
}
