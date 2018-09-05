package com.learn.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class CricketCoach implements Coach {

	//INTERNALLY USES JAVA REFLECTION API
	@Autowired
	@Qualifier("randomService")
	private FortuneService fortuneService;

	// Create a NO-ARGS constructor
	public CricketCoach() {
		System.out.println("CricketCoach: inside no-arg constructor");
	}

	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes";
	}

	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	@PostConstruct
	public void doStart() {
		System.out.println("Execute after constructor & injection of dependencies");
	}
	
	@PreDestroy
	public void doEnd() {
		System.out.println("Execute before spring bean is destroyed");
	}

}
