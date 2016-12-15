package com.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.service.User;

@Service
public class UserImpl implements User {
	private final Logger log = LoggerFactory.getLogger(UserImpl.class);;

	public void showName(String name) {
		log.info("info message~~~~~~~~~~~~~~~~~~!!!!!!!!!!");
		System.out.println("the name is:" + name);
	}

}
