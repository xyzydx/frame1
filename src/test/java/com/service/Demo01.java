package com.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/*
 * spring
 */
public class Demo01 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
		User u = (User) context.getBean("user");
		u.showName("haha");
	}

	@Test
	public void main() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
		User u = (User) context.getBean("user");
		u.showName("haha");
	}
}
