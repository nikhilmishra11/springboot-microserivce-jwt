package com.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.PaymentRequestDTO;
import com.demo.dto.PaymentResponseDTO;
import com.demo.service.PaymentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService service;

    @PostMapping
    public PaymentResponseDTO getOrder(@Valid @RequestBody PaymentRequestDTO dto) {
    	log.info("PaymentController.getOrder(): request: {}", dto);
        return service.createPayment(dto);
    }
}
