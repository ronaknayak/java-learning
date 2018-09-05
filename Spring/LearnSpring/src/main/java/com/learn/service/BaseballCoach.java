package com.learn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

	// define a private field for the dependency
	private FortuneService fortuneService;
	
	// Create a NO-ARGS constructor
	public BaseballCoach() {
		System.out.println("BaseballCoach: inside no-arg constructor");
	}

	/**
	 * @param fortuneService the fortuneService to set
	 * 
	 * Apart from setter, we can set even our custom method.
	 */
	@Autowired
	@Qualifier("happyFortuneService")
	public void doInstanciation(FortuneService fortuneService) {
		System.out.println("BaseballCoach.setFortuneService()");
		this.fortuneService = fortuneService;
	}

	public String getDailyWorkout() {
		return "Spend 30 minutes on baseball batting practice";
	}

	public String getDailyFortune() {
		// use my fortuneService to get a fortune
		return fortuneService.getFortune();
	}
}
