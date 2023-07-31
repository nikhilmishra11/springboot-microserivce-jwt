package com.demo.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.demo.dto.PaymentRequestDTO;
import com.demo.dto.PaymentResponseDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PaymentServiceClient {
	
    private final RestTemplate template;

    public PaymentResponseDTO makePayment(PaymentRequestDTO dto) {
        return template.postForObject("http://PAYMENT-SERVICE/payment",dto, PaymentResponseDTO.class);
    }
}
