package com.eventoAS.web;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;


@RestController
public class UserInfoController {

		@GetMapping(value="/userinfo")
		public HashMap<String, Object> user( Principal principal) {

		  System.err.println("UserInfoController.user()");

				HashMap<String, Object>  userInfoMap= new HashMap<>();
				userInfoMap.put("username", principal.getName());
				userInfoMap.put("authorities", SecurityContextHolder.getContext().getAuthentication().getAuthorities());
				userInfoMap.put("tokenValue", ((OAuth2AuthenticationDetails)((OAuth2Authentication) principal).getDetails()).getTokenValue());

			  return userInfoMap;
		}
}
