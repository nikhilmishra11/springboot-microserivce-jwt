package com.demo.service;

import org.springframework.stereotype.Service;

import com.demo.dto.PaymentRequestDTO;
import com.demo.dto.PaymentResponseDTO;

@Service
public class PaymentService {

    public PaymentResponseDTO createPayment(PaymentRequestDTO dto) {
        return PaymentResponseDTO.builder()
        		.amount(dto.getAmount())
        		.cardNumber(dto.getCardNumber())
        		.build();
    }
}
