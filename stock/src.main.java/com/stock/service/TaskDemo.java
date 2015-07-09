package com.stock.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskDemo {

	@Scheduled(cron = "0 0 17 * * ? ")
	public void execute(){
		System.out.println("Task is Execute");
	}
}
