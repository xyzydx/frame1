package com.service;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/*
 * testng+spring+mybatis结合
 */
@ContextConfiguration(locations = { "classpath:Application.xml" })
// @Listeners({ CustomReporter.class, MyTestListenerAdapter.class })
public class BaseCase extends AbstractTestNGSpringContextTests {

}
