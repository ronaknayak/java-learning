package com.learn.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learn.service.Coach;

public class App {

	public static void main(String[] args) {

		// load the spring configuration file
		// ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// After Replacing XML with modern Java class configuration
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		// retrieve bean from spring container
		
		//Coach theCoach = context.getBean("trackCoachService", Coach.class);
		
		//Coach theCoach = context.getBean("BaseballCoach", Coach.class);
		
		//Coach theCoach = context.getBean("cricketCoach", Coach.class);
		
		Coach theCoach = context.getBean("swimCoach", Coach.class);
		
		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// let's call our new method for fortunes
		System.out.println(theCoach.getDailyFortune());
		
		// close the context
		context.close();
	}

}







