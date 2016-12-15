package com.testng;


import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestRetry implements IRetryAnalyzer {

	private final int MAX_RETRY_COUNT = 5;
	private int retryCount = 0;

	public boolean retry(ITestResult result) {
		if (retryCount < MAX_RETRY_COUNT) {
			retryCount++;
			return true;
		}
		return false;
	}

}
