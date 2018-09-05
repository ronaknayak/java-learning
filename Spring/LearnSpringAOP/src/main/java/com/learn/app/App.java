package com.learn.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learn.dao.AccountDAO;

public class App {

	public static void main(String[] args) {

		// After Replacing XML with modern Java class configuration
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// call the business method
		theAccountDAO.addAccount();

		// do it again!
		System.out.println("\nlet's call it again!\n");

		// call the business method again
		theAccountDAO.addAccount();

		// close the context
		context.close();
	}

}
