package com.service;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.testng.CustomReporter;

/*
 * 自定义Reporter处理
 */
@Listeners({ CustomReporter.class })
public class Demo06 {
	@Test
	public void e1() {
	}

	@Test
	public void e2() {
		Reporter.log("<===========Method name is e2", true);
	}

}
