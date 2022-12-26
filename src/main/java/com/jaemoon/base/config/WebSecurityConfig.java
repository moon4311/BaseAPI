package com.jaemoon.base.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Autowired
	private SuccessHandler successHandler;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)  throws Exception {
		http
			.csrf().disable()
			.authorizeHttpRequests(
				(requests) -> requests
				.antMatchers("/", "/*/**").permitAll()
				.anyRequest().authenticated()
			)
			.formLogin(
				(form) -> form
				.loginPage("/login")
				.loginProcessingUrl("/loginProcess")
				.usernameParameter("username")
				.passwordParameter("password")
				.successHandler(successHandler)
				.permitAll()
			)
			.logout((logout) -> logout.permitAll());
		
		return http.build();
	}

}
