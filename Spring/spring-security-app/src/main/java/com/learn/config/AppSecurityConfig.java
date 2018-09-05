package com.learn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// Add users for in-memory authentication
		UserBuilder users = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication()
				.withUser(users.username("ronak").password("ronak").roles("EMPLOYEE"))
				.withUser(users.username("richa").password("richa").roles("EMPLOYEE", "ADMIN"))
				.withUser(users.username("dipen").password("dipen").roles("EMPLOYEE", "MANAGER"));
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		// .anyRequest().authenticated()
		.antMatchers("/").hasRole("EMPLOYEE")
		.antMatchers("/leaders/**").hasRole("MANAGER")
		.antMatchers("/systems/**").hasAnyRole("MANAGER", "ADMIN")
		.and()
			.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/authenticate")
			.permitAll()
		.and()
			.logout()
			.permitAll()
		.and()
			.exceptionHandling()
			.accessDeniedPage("/access-denied");
	}

}
