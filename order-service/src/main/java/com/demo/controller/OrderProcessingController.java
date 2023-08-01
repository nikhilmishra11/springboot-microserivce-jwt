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
@RequestMapping("/process")
@RequiredArgsConstructor
public class OrderProcessingController {

	private final OrderService orderService;

    @PostMapping
    public OrderResponseDTO processOrder(@RequestBody OrderRequestDTO dto) {
    	log.info("OrderProcessingController.processOrder(): Request: {}", dto);
        return orderService.processOrder(dto);
    }
    
    @GetMapping("/{orderId}")
	public ResponseEntity<String> getStatus(@PathVariable Long orderId) {
    	log.info("OrderProcessingController.getStatus(): order id: {}", orderId);
		return ResponseEntity.ok(orderService.getStatus(orderId));
	}
}
