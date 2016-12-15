package com.service;

import javax.annotation.Resource;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jdbc.BaseDao;

/*
 * 继承基类进行测试
 */
public class Demo07 extends BaseCase {
	@Resource
	private BaseDao baseDao;
	@Resource
	private User user;
	private int n = 3;

	@Test(description = "查询")
	public void testNo1() {
		String name = baseDao.queryForObject("xg.t_crm_xg_order_iAsyncFlag", "1359756");
		Reporter.log("<===========name is " + name, true);
		n--;
		Assert.assertTrue(n > 0, "现在是大于的,n=" + n);
		// throw new RuntimeException("事物回滚");
	}
}
