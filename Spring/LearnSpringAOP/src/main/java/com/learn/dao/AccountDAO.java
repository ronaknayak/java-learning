package com.learn.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	public void addAccount() {
		System.out.println(this.getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
}
