package com.eventoAS.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.eventoAS"})
public class EventoAsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventoAsApplication.class, args);
	}

}
