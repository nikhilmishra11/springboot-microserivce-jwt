package com.demo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.demo.dto.OrderRequestDTO;
import com.demo.dto.OrderResponseDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderServiceClient {
    @Autowired
    private RestTemplate template;

    @Async
    public OrderResponseDTO dispatchOrder(OrderRequestDTO dto) {
        return template.postForObject("http://ORDER-SERVICE/process",dto, OrderResponseDTO.class);
    }
    

	public String getStatus(String orderId) {
		return template.getForObject("http://ORDER-SERVICE/process/"+orderId, String.class);
	}
}
