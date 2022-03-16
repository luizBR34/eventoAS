package com.eventoAS.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/* Docker
	docker build -t luizpovoa/eventoas:0.0.1-SNAPSHOT .
	docker run -p 8081:8081 -d --env VAULT_HOST=172.18.0.2 --env VAULT_ROOT_TOKEN=s.MvyZ4i7suJRAzO3tMVCRadPC --env EVENTOAPP_HOST=https://172.18.0.8:8443 --env EVENTO_CACHE_URI=http://172.18.0.9:8585 --env EVENTO_WS_URI=http://172.18.0.11:9090 --env EVENTOANGULAR_HOST=http://172.18.0.5:4200 --network eventoapp-network --name EventoAS luizpovoa/eventoas:0.0.1-SNAPSHOT
*/

@SpringBootApplication
@EnableFeignClients("com.eventoRS.clients")
@ComponentScan({"com.eventoAS", "com.eventoRS.services"})
public class EventoAsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventoAsApplication.class, args);
	}
}
