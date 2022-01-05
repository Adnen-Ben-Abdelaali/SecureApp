package com.telusko.secureapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{
	
	private UserDetailsService userDetailsService;
	
	/*

	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		
		List<UserDetails> users = new ArrayList<>();
		
		users.add(User.withDefaultPasswordEncoder().username("Navin").password("1234").roles("USER").build());
		
		return new InMemoryUserDetailsManager(users);
	}
	
	*/
	
	@Bean 
	public AuthenticationProvider authProvider() {
		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		
		
		return provider;
	}
	
	
	
}
