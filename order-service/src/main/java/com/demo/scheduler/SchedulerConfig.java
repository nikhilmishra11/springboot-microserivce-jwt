package com.demo.scheduler;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.demo.service.OrderService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class SchedulerConfig {

	private final OrderService orderService;
	
	@Scheduled(fixedDelay = 60*1000*60) 
	public void updateOrderStatus() {
		log.info("SchedulerConfig.updateOrderStatus()");
		orderService.updateStatus();
	}
}