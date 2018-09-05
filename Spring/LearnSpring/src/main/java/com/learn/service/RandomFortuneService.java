package com.learn.service;

import org.springframework.stereotype.Component;

@Component("randomService")
public class RandomFortuneService implements FortuneService {

	public String getFortune() {
		return "It's randomly found for you!";
	}

}
