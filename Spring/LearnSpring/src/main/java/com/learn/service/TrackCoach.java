package com.learn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("trackCoachService")
public class TrackCoach implements Coach {

	private FortuneService fortuneService;

	// Create a NO-ARGS constructor
	public TrackCoach() {
		System.out.println("TrackCoach: inside no-arg constructor");
	}
	
	/**
	 * This will search all the component i.e.spring bean implementing 
	 * FortuneService interface & inject the dependency.
	 */
	@Autowired
	public TrackCoach(@Qualifier("happyFortuneService") FortuneService fortuneService) {
		System.out.println("TrackCoach: inside parameterized constructor");
		this.fortuneService = fortuneService;
	}

	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	public String getDailyFortune() {
		return "Just Do It: " + fortuneService.getFortune();
	}

}
