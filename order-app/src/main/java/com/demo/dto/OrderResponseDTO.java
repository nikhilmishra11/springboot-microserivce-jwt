package com.demo.dto;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponseDTO {

    private String orderId;
    private double price;
    private LocalDateTime orderDate;
    private String status;
    private int estimateDeliveryWindow;
    private Product product;
    private PaymentResponseDTO paymentResponseDTO;
    
}
