package com.eventoAS.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients("com.eventoApp.clients")
@ComponentScan({"com.eventoAS", "com.eventoApp.services"})
public class EventoAsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventoAsApplication.class, args);
	}

}
