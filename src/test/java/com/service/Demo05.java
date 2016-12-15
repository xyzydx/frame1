package com.service;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.testng.MyTestListenerAdapter;
import com.testng.TestRetry;

/*
 *用自定义的监听器实现截图、删除重复错误记录等操作
 */
@Listeners({ MyTestListenerAdapter.class })
public class Demo05 {
	private int i = 4;

	/* retryAnalyzer实现失败重跑 */
	@Test(retryAnalyzer = TestRetry.class, description = "失败重试")
	public void t1() {
		System.out.println("t1 is running!!!!!  i=" + i);
		i--;
		assert i < 0;
	}

}
