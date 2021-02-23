package com.eventoAS.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eventoAS.models.User;

@Service
public class DefaultClientService implements ClientService {
	
	private Logger log = LoggerFactory.getLogger(DefaultClientService.class);
	
	@Value(value = "${eventocache.endpoint.uri}")
	private String eventoCacheEndpointURI;
	
	RestTemplate restTemplate = new RestTemplate();

	@Override
	public User seekUser(String login) {

		log.info("START - DefaultClientService:seekUser()");

		String path = eventoCacheEndpointURI + "/seekUser/" + login;

		ResponseEntity<User> responseEntity = restTemplate.exchange(path, HttpMethod.GET, null, User.class);
		User user = null;

		if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
			log.info("ClientServiceImpl:seekUser() - EventoCache API responded the request successfully!");
			user = responseEntity.getBody();
		} else {
			log.error("Error when request event's list from API!");
		}

		log.info("END - DefaultClientService:seekUser()");
		return user;
		
	}

}
