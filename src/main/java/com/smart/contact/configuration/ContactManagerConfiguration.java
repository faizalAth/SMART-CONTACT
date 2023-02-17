package com.smart.contact.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ContactManagerConfiguration {

	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder(); 
	}
	
	@Bean 
	public UserDetailsServiceImpl getusDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
		authenticationProvider.setPasswordEncoder(getPasswordEncoder());
		authenticationProvider.setUserDetailsService(getusDetailsService());
		return authenticationProvider;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
		security.authenticationProvider(daoAuthenticationProvider());
		
		security.authorizeHttpRequests().requestMatchers("/user/**").hasRole("USER").requestMatchers("/admin/**").hasRole("ADMIN")
										.requestMatchers("/**").permitAll().and().formLogin().and().csrf().disable();
		
		return security.build();
	}
}
