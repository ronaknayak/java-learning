package com.learn.service;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;

	// Create a NO-ARGS constructor
	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	public String getDailyWorkout() {
		return "Swimming is best for health";
	}

	public String getDailyFortune() {
		return "Just Do swimming: " + fortuneService.getFortune();
	}

}
