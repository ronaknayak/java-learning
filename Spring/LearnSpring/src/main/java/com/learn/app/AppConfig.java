package com.learn.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.learn.service.Coach;
import com.learn.service.FortuneService;
import com.learn.service.SadFortuneService;
import com.learn.service.SwimCoach;

@Configuration
@ComponentScan("com.learn.service")
public class AppConfig {
	
	/**
	 * Define bean for our fortune service
	 * 
	 * NOTE: Method name will be treated as bean ID and it would be 
	 * used by spring container to register that bean. 
	 */
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	/**
	 * Define method for swim coach & inject dependency
	 */
	@Bean
	public Coach swimCoach() {
		SwimCoach swimCoach = new SwimCoach(sadFortuneService());
		return swimCoach;
	}
}
