package com.demo.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Service;

import com.demo.client.OrderServiceClient;
import com.demo.client.PaymentServiceClient;
import com.demo.dto.OrderRequestDTO;
import com.demo.dto.OrderResponseDTO;
import com.demo.dto.PaymentRequestDTO;
import com.demo.dto.PaymentResponseDTO;
import com.demo.dto.Product;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final PaymentServiceClient paymentServiceClient;
    private final OrderServiceClient orderServiceClient;
	private final ProductService productService;
	
	public Optional<OrderResponseDTO> createOrder(OrderRequestDTO dto) {
		Product product = productService.findProductById(dto.getProductId());
		PaymentRequestDTO paymentRequestDTO = PaymentRequestDTO.builder()
				.amount(dto.getAmount())
				.cardNumber(dto.getCardNumber())
				.build();
		PaymentResponseDTO fetchOrderStatus = paymentServiceClient.makePayment(paymentRequestDTO);
		orderServiceClient.dispatchOrder(dto);
		return Optional.ofNullable(OrderResponseDTO.builder()
				.price(dto.getAmount())
				.product(product)
				.orderDate(LocalDateTime.now())
				.paymentResponseDTO(fetchOrderStatus)
				.build());
	}

	public String getStatus(String orderId) {
		return orderServiceClient.getStatus(orderId);
	}
}
