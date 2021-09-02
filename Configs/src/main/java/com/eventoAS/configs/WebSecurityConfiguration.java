package com.eventoAS.configs;

import com.eventoRS.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
@Order(1)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/logar/**", "/logout/**").permitAll()
		.antMatchers("/oauth/authorize/**").authenticated()
		.and()
			.formLogin()
			.loginPage("http://localhost:4200/home?login=true")
			.loginProcessingUrl("/logar/**")
		.and()
			.requestMatchers()
			.antMatchers("/oauth/authorize/**", "/logar/**")
		.and()
			.logout()
			.logoutUrl("/logout");
	}
	
	

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws java.lang.Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	

	//authenticationProvider bean definition
	@Bean
	@Autowired 
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(encoder);
		daoAuthenticationProvider.setUserDetailsService(userService);
		return daoAuthenticationProvider;
	}
	

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}